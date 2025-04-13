package CompletatableFuture;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;




public class PedidosCompletableFuture {
    // Simula um banco de dados de produtos
    private static final Map<Integer, Integer> estoque = Map.of(
            1, 10,  // Produto ID 1, quantidade 10
            2, 5,   // Produto ID 2, quantidade 5
            3, 8    // Produto ID 3, quantidade 8
    );

    // Simula um serviço de cálculo de frete
    private static CompletableFuture<Double> calcularFreteAsync(int produtoId, String cep) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simula tempo de processamento
                Thread.sleep(100 + new Random().nextInt(400));
                // Frete baseado no ID do produto (valor fictício)
                return 10.0 + (produtoId * 2.5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    // Simula verificação de estoque
    private static CompletableFuture<Boolean> verificarEstoqueAsync(int produtoId, int quantidade) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simula tempo de verificação
                Thread.sleep(50 + new Random().nextInt(200));
                return estoque.getOrDefault(produtoId, 0) >= quantidade;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    // Simula geração de fatura
    private static CompletableFuture<String> gerarFaturaAsync(int pedidoId, double valorTotal) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simula tempo de geração
                Thread.sleep(200 + new Random().nextInt(300));
                return "Fatura-P" + pedidoId + "-" + System.currentTimeMillis() + ".pdf";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }


    // Processa um pedido individual
    static CompletableFuture<Map<String, Object>> processarPedidoAsync(Pedido pedido) {
        // Verifica estoque em paralelo para todos os itens
        List<CompletableFuture<Boolean>> verificacoesEstoque = pedido.getItens().stream()
                .map(item -> verificarEstoqueAsync(item.getProdutoId(), item.getQuantidade()))
                .collect(Collectors.toList());

        // Calcula fretes em paralelo
        List<CompletableFuture<Double>> calculosFrete = pedido.getItens().stream()
                .map(item -> calcularFreteAsync(item.getProdutoId(), pedido.getCep()))
                .collect(Collectors.toList());

        // Combina todas as verificações de estoque
        CompletableFuture<Boolean> estoqueOk = CompletableFuture.allOf(
                        verificacoesEstoque.toArray(new CompletableFuture[0]))
                .thenApply(v -> verificacoesEstoque.stream()
                        .allMatch(CompletableFuture::join));

        // Soma todos os fretes
        CompletableFuture<Double> freteTotal = CompletableFuture.allOf(
                        calculosFrete.toArray(new CompletableFuture[0]))
                .thenApply(v -> calculosFrete.stream()
                        .mapToDouble(CompletableFuture::join)
                        .sum());

        // Calcula o valor total dos produtos
        double valorProdutos = pedido.getItens().stream()
                .mapToDouble(item -> item.getPrecoUnitario() * item.getQuantidade())
                .sum();

        // Combina todos os resultados
        return estoqueOk.thenCompose(estoqueDisponivel -> {
            if (!estoqueDisponivel) {
                Map<String, Object> resultadoErro = new HashMap<>();
                resultadoErro.put("pedidoId", pedido.getId());
                resultadoErro.put("status", "ERRO");
                resultadoErro.put("mensagem", "Produto sem estoque disponível");
                return CompletableFuture.completedFuture(resultadoErro);
            }

            // Agora combinamos com o freteTotal
            return freteTotal.thenCompose(frete -> {
                double valorTotal = valorProdutos + frete;

                return gerarFaturaAsync(pedido.getId(), valorTotal)
                        .thenApply(fatura -> {
                            Map<String, Object> resultado = new HashMap<>();
                            resultado.put("pedidoId", pedido.getId());
                            resultado.put("status", "SUCESSO");
                            resultado.put("valorProdutos", valorProdutos);
                            resultado.put("frete", frete); // valor resolvido
                            resultado.put("valorTotal", valorTotal);
                            resultado.put("fatura", fatura);
                            resultado.put("itens", pedido.getItens().size());
                            return resultado;
                        });
            });
        });


    }
    }
