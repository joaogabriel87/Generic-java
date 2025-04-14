package Threads.ProdutorConsumer;

import java.security.SecureRandom;

public class Consumer implements Runnable {
    private Buffer sharedLocation;
    private static final SecureRandom generator = new SecureRandom();

    public Consumer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    public void run() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            try{
                Thread.sleep(generator.nextInt(3000));
                sharedLocation.blockingGet(i);
                sum += i;
                System.out.println(sum);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumer read values totaling" + sum + "Terminating Consumer");
    }
}
