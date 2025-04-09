package Exercicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountWord {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        String[] words = input.split("\\s+");

        for (String word : words) {
            String letter = String.valueOf(word);
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        System.out.println("Contagem de frequencia");
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
