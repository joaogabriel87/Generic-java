package Threads.ProdutorConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedBufferTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        Buffer sharedLocation = new UnsynchronizedBuffer();

        System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
        System.out.printf("------\t\t-----\t---------------\t---------------%n%n");

        executor.execute(new Producer(sharedLocation));
        executor.execute(new Consumer(sharedLocation));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
