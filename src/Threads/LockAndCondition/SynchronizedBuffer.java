package Threads.LockAndCondition;

import Threads.ProdutorConsumer.Buffer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class SynchronizedBuffer implements Buffer {
    // Bloqueio para controlar sincronização com esse buffer
    private final Lock accessLock = new ReentrantLock();

    // condições para controlar leitura e gravação
    private final Condition canWrite = accessLock.newCondition();
    private final Condition canRead = accessLock.newCondition();

    private int buffer = -1; // compartilhado pelas threads producer e consumer
    private boolean occupied = false; // se o buffer estiver ocupado

    // coloca o valor int no buffer
    public void blockingPut(int value) throws InterruptedException {
        accessLock.lock(); // bloqueia esse objeto

        try {
            // enquanto o buffer não estiver vazio, coloca thread no estado de espera
            while (occupied) {
                System.out.println("Producer tries to write.");
                displayState("Buffer full. Producer waits.");
                canWrite.await(); // espera até que o buffer esteja vazio
            }

            buffer = value; // configura novo valor de buffer
            occupied = true; // indica que o buffer está ocupado

            displayState("Producer writes " + buffer);
            canRead.signalAll(); // sinaliza threads esperando para ler
        }
        finally {
            accessLock.unlock(); // desbloqueia esse objeto
        }
    }

    @Override
    public int blockingGet(int value) throws InterruptedException {
        return 0;
    }

    // retorna valor do buffer
    public int blockingGet() throws InterruptedException {
        int readValue = 0;
        accessLock.lock(); // bloqueia esse objeto

        try {
            // se não houver dados para ler, coloca thread em espera
            while (!occupied) {
                System.out.println("Consumer tries to read.");
                displayState("Buffer empty. Consumer waits.");
                canRead.await(); // espera até o buffer ficar cheio
            }

            occupied = false; // indica que o buffer está vazio
            readValue = buffer; // recupera o valor do buffer

            displayState("Consumer reads " + readValue);
            canWrite.signalAll(); // sinaliza threads esperando para escrever
        }
        finally {
            accessLock.unlock(); // desbloqueia esse objeto
        }

        return readValue;
    }

    // exibe a operação atual e o estado de buffer
    private void displayState(String operation) {
        accessLock.lock(); // bloqueia esse objeto

        try {
            System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
        }
        finally {
            accessLock.unlock(); // desbloqueia esse objeto
        }
    }
} // fim da classe SynchronizedBuffer