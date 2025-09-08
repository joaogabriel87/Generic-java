package Threads.PCSynchronized;

public class main {
    public static void main(String[] args) {
        ProdutorConsumidorSynchronized pc = new ProdutorConsumidorSynchronized(5);

        new Thread(() -> {
            try{
                for (int i = 0; i < 10; i++) {
                    pc.produce(i);
                    Thread.sleep(100);
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try{
                for (int i = 0; i < 10; i++) {
                    pc.consume();
                    Thread.sleep(150);
                }
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
