package Exercicios;

import java.util.Collections;
import  java.util.PriorityQueue;

public class PriorityQueueExercicio {
    public static void main(String[] args) {
       PriorityQueue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.offer(3.2);
        queue.offer(9.8);
        queue.offer(5.4);


        while(!queue.isEmpty()){
            System.out.printf("%.1f " + queue);
            queue.poll();
        }
    }
}
