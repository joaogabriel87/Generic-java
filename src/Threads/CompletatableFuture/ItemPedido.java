package Threads.CompletatableFuture;

public class ItemPedido {
    private final int produtoId;
    private final int quantidade;
    private final double precoUnitario;

    public ItemPedido(int produtoId, int quantidade, double precoUnitario) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}
