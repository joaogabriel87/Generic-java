package Threads.Executor;

import java.security.SecureRandom;

public class PrintTask implements Runnable{
    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime; // tempo de adormecimento aleatório para a thread
    private final String taskName;

    // construtor
    public PrintTask(String taskName)
    {
        this.taskName = taskName;

        // seleciona tempo de adormecimento aleatório entre 0 e 5 segundos
        sleepTime = generator.nextInt(5000); // milissegundos
    }

    // método run contém o código que uma thread executará
    public void run()
    {
        try // coloca a thread para dormir pela quantidade de tempo sleepTime
        {
            System.out.printf("%s going to sleep for %d milliseconds.%n", taskName, sleepTime);
            Thread.sleep(sleepTime); // coloca a thread para dormirÿ
        }
        catch (InterruptedException exception)
        {
            exception.printStackTrace();
            Thread.currentThread().interrupt(); // reinterrompe a thread
        }

        // imprime o nome da tarefa
        System.out.printf("%s done sleeping%n", taskName);
    }
}
