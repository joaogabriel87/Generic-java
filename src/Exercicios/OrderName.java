package Exercicios;

import java.util.*;

public class OrderName {
    public static void main(String[] args) {
        String[] name = {"JOAO", "GABRIEL", "ALEX", "BIANCA", "CARLOS", "DEBORA", "OTAVIO", "RIVALDO", "FEITOSA", "SARA", "CLEINTO"};
        List<String> names = new LinkedList<>(Arrays.asList(name));

        System.out.println("Nomes antes de ordernar" + names);
        Collections.sort(names);
        System.out.println("Nomes ordenados ");
        names.forEach(System.out::println);

    }
}
