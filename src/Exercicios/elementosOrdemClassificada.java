package Exercicios;

import java.sql.Array;
import java.util.*;

public class elementosOrdemClassificada {
    public static void main(String[] args) {
        Random rand = new Random();
        LinkedList<Integer> list = new LinkedList<>();


        for (int i = 0; i < 25; i++) {
            int num = rand.nextInt(101);
            insertOrdernad(list, num);
        }

        System.out.println("Lista ordenada: " + list);

        int soma = 0;
        for (int num :list) {
            soma += num;
        }
        double media = soma / list.size();

        System.out.println("Soma dos elementos: " + soma);
        System.out.printf("Média dos elementos: %.2f%n", media);
    }

    private static void insertOrdernad(LinkedList<Integer> list, int num) {
        int index = 0;
        while (index < list.size() && list.get(index) < num) {
            index++;
        }
        list.add(index, num);
    }
}
