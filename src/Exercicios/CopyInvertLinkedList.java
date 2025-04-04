package Exercicios;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class CopyInvertLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> list1 = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("Escreve o Caracter:");
            String caracter = sc.nextLine();
            list1.add(caracter);
        }

        System.out.println("Primeira Lista" + list1);

        LinkedList<String> list2 = new LinkedList<>(list1);
        Collections.reverse(list2);

        System.out.println("Segunda lista" + list2);



    }
}
