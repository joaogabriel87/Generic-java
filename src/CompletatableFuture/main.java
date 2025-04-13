package CompletatableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static CompletatableFuture.PedidosCompletableFuture.processarPedidoAsync;

public class main {
    public static void main(String[] args) {
        // Cria um pool de threads customizado
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Configura o ForkJoinPool padrão para usar nosso executor
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "10");

        // Simula uma lista de pedidos a serem processados
        List<Pedido> pedidos = Arrays.asList(
                new Pedido(1, "01001000", Arrays.asList(
                        new ItemPedido(1, 2, 29.90),
                        new ItemPedido(2, 1, 59.90)
                )),
                new Pedido(2, "02002000", Arrays.asList(
                        new ItemPedido(3, 3, 19.90),
                        new ItemPedido(1, 1, 29.90)
                )),
                new Pedido(3, "03003000", Arrays.asList(
                        new ItemPedido(2, 10, 59.90)  // Quantidade maior que estoque
                )),
                new Pedido(4, "04004000", Arrays.asList(
                        new ItemPedido(1, 1, 29.90),
                        new ItemPedido(2, 1, 59.90),
                        new ItemPedido(3, 2, 19.90)
                ))
        );

        System.out.println("Iniciando processamento de " + pedidos.size() + " pedidos...");
        long startTime = System.currentTimeMillis();

        // Processa todos os pedidos em paralelo
        List<CompletableFuture<Map<String, Object>>> processamentos = pedidos.stream()
                .map(pedido -> processarPedidoAsync(pedido))
                .collect(Collectors.toList());

        // Aguarda todos os processamentos terminarem
        CompletableFuture<Void> todosPedidos = CompletableFuture.allOf(
                processamentos.toArray(new CompletableFuture[0]));

        // Obtém os resultados
        List<Map<String, Object>> resultados = todosPedidos.thenApply(v -> processamentos.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()))
                .join();

        long tempoTotal = System.currentTimeMillis() - startTime;

        System.out.println("TESTE" + resultados);

        System.out.println("\nResultados do processamento:");
        resultados.forEach(resultado -> {
            System.out.println("\nPedido ID: " + resultado.get("pedidoId"));
            System.out.println("Status: " + resultado.get("status"));

            if ("SUCESSO".equals(resultado.get("status"))) {
                System.out.printf("Valor produtos: R$%.2f%n", resultado.get("valorProdutos"));
                System.out.printf("Frete: R$%.2f%n", resultado.get("frete"));
                System.out.printf("Valor total: R$%.2f%n", resultado.get("valorTotal"));
                System.out.println("Fatura: " + resultado.get("fatura"));
                System.out.println("Itens processados: " + resultado.get("itens"));
            } else {
                System.out.println("Erro: " + resultado.get("mensagem"));
            }
        });

        System.out.printf("\nTempo total de processamento: %d ms%n", tempoTotal);
        executor.shutdown();
    }
}
