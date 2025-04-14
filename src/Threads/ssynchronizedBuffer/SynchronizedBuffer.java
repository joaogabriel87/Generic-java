package Threads.ssynchronizedBuffer;

import Threads.ProdutorConsumer.Buffer;

public class SynchronizedBuffer implements Buffer {
    private int buffer = -1;
    private boolean occupied = false;



    @Override
    public synchronized void blockingPut(int value) throws InterruptedException {
        while (occupied) {
            System.out.println("Producer tries to write");
            displayState("Buffer full, producer waits");
            wait();
        }
        buffer = value;

        occupied = true;

        displayState("Producer write " + buffer);

        notifyAll();
    }

    @Override
    public synchronized int blockingGet(int value) throws InterruptedException {
        while (!occupied) {
            System.out.println("Consumer tries to write");
            displayState("Buffer empty, consumer waits");
            wait();
        }
        buffer = value;

        occupied = false;

        displayState("Producer reads " + buffer);

        notifyAll();

        return buffer;
    }

    @Override
    public int blockingGet() throws InterruptedException {
        return 0;
    }

    private void displayState(String operation) {
        System.out.printf(operation +""+ ""+buffer +""+ ""+occupied);
    }
}
