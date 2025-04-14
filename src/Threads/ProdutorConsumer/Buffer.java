package Threads.ProdutorConsumer;

public interface Buffer {
    public void blockingPut(int value) throws InterruptedException;

    public int blockingGet(int value) throws InterruptedException;

    // retorna valor do buffer
    int blockingGet() throws InterruptedException;
}
