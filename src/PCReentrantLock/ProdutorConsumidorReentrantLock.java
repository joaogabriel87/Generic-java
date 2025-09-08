package PCReentrantLock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdutorConsumidorReentrantLock {
    private final Queue<Integer> buffer = new LinkedList();
    private final int capacidade;
    private final Lock lock = new ReentrantLock();
    private final Condition bufferCNaoCheio = lock.newCondition();
    private final Condition bufferNaoVazio = lock.newCondition();

    public ProdutorConsumidorReentrantLock(int capacidade) {
        this.capacidade = capacidade;
    }
    public void produce(int valor) throws InterruptedException {
        lock.lock();
        try{
            while (buffer.size() == capacidade){
                System.out.println("Buffer cheio, produtor agurdadno");
                bufferCNaoCheio.await();
            }
            buffer.add(valor);
            System.out.println("Producido: " + valor);
            bufferNaoVazio.signal();
        }finally {
            lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while(buffer.isEmpty()){
                System.out.println("Buffer vazio, consumer agurdando");
                bufferNaoVazio.await();
            }
            int valor = buffer.remove();
            System.out.println("Consumido: " + valor);
            bufferCNaoCheio.signal();
            return valor;
        } finally {
            lock.unlock();
        }
    }
}
