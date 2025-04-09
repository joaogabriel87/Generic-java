package Exercicios;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class OrderAutomatic {
    public static void main(String[] args) {
        Random rand = new Random();
        Set<Integer> number = new TreeSet<>();

        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100);
            System.out.println("Numero aleatorio " + num);
            number.add(num);
        }

        number.forEach(System.out::println);


    }
}
