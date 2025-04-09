package Exercicios;

import java.util.PriorityQueue;

public class FilaAtendimento {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.offer("JOAO");
        pq.offer("GABRIEL");
        pq.offer("FEITOSA");
        pq.offer("ANA");
        pq.offer("THAIS");

        while (!pq.isEmpty()) {
            System.out.println("FILA " + pq.peek());
            pq.poll();
        }

        System.out.println(pq);

    }
}
