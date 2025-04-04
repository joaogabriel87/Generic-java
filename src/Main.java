import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        System.out.println("Iniciando demostração");

        List<Object> objectsList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            objectsList.add(new byte[1024]);
        }

        printMemoryStats(memoryMXBean, "Antes de liberar memoria");

        objectsList.clear();
        System.out.println("\nReferencias liberadas. o GC pode coletar agora");
        printMemoryStats(memoryMXBean, "Depois de liberar");

        // Tentar forçar o GC (lembrando que isso é apenas uma sugestão)
        System.out.println("\nSolicitando Garbage Collection...");
        System.gc();

        Thread.sleep(2000);
        printMemoryStats(memoryMXBean, "Depois de System.gc");
        System.out.println("\nDemostrando concluida. Verifique o VisualVM para detalhes");



    }

    private static void printMemoryStats(MemoryMXBean memoryMXBean, String momento) {
        MemoryUsage heapUsage = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage nonHeapUsage = memoryMXBean.getNonHeapMemoryUsage();

        System.out.println("\n--- " + momento + " ---");
        System.out.println("Heap Memory:");
        System.out.printf("  Usado: %,d KB%n", heapUsage.getUsed() / 1024);
        System.out.printf("  Máximo: %,d KB%n", heapUsage.getMax() / 1024);

        System.out.println("Non-Heap Memory:");
        System.out.printf("  Usado: %,d KB%n", nonHeapUsage.getUsed() / 1024);
        System.out.printf("  Máximo: %,d KB%n", nonHeapUsage.getMax() / 1024);
    }



}