package PCReentrantLock;

public class main {
    public static void main(String[] args) {
        ProdutorConsumidorReentrantLock pc = new ProdutorConsumidorReentrantLock(5);

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    pc.produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Consumidor
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    pc.consume();
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
    }

