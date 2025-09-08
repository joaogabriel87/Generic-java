package Threads.PCSynchronized;

import java.util.LinkedList;
import java.util.Queue;

public class ProdutorConsumidorSynchronized {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacidade;

    public ProdutorConsumidorSynchronized (int capacidade) {
        this.capacidade = capacidade;
    }
    public synchronized void produce(int valor) throws InterruptedException {
        while( buffer.size() == capacidade ) {
            System.out.println("Buffer cheio. Produtor aguardando");
            wait();
        }

        buffer.add(valor);
        System.out.println("Produzindo: " + valor);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while(buffer.isEmpty()) {
            System.out.println("Buffer vazio, aguardando");
            wait();
        }
        int valor = buffer.remove();
        System.out.println("Consumido: " + valor);
        notifyAll();
        return valor;
    }
}
