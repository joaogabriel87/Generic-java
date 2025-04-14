package Threads.ssynchronizedBuffer;

import Threads.ProdutorConsumer.Buffer;
import Threads.ProdutorConsumer.Consumer;
import Threads.ProdutorConsumer.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Buffer sharedLocation = new SynchronizedBuffer();

        System.out.printf("Operation", "Buffer", "Occupied", "---------", "------\t\t--------");
        executor.execute(new Producer(sharedLocation));
        executor.execute(new Consumer(sharedLocation));
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);


    }
}
