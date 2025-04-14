package Threads.CompletatableFuture;

import java.util.List;

public class Pedido {
    private final int id;
    private final String cep;
    private final List<ItemPedido> itens;

    public Pedido(int id, String cep, List<ItemPedido> itens) {
        this.id = id;
        this.cep = cep;
        this.itens = itens;
    }

    public int getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}
