package Exercicios;

import java.lang.management.MemoryMXBean;
import java.util.*;

public class Exercicio {

    public static void main(String[] args) {
        String[] color = {"red", "white", "blue", "green", "gray",
                "orange", "tan", "white", "cyan", "peach", "gray", "orange", "laranja", "laranja"};
        List<String> list1 = Arrays.asList(color);
        System.out.println(list1);

        printNonduplicates(list1);
    }

    private static void printNonduplicates(Collection<String> values) {
        Set<String> set = new HashSet<>(values);
        System.out.printf("%nNon duplicates are: ");
        for(String value :set){
            System.out.print(value);
            System.out.println();
        }

    }
}
