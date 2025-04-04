package Exercicios;

import java.util.*;

public class CountDuplicate {
    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        createMap(wordCount);
        displayMap(wordCount);
    }

    private static void createMap(Map<String, Integer> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a frase: ");
        String frase = scanner.nextLine().toLowerCase();

        // Remove pontuação
        frase = frase.replaceAll("[^a-zA-Z ]", "");

        // Divide em palavras
        String[] tokens = frase.split("\\s+"); // Divide por espaços

        // Conta as palavras
        for (String token : tokens) {
            if (!token.isEmpty()) {
                map.put(token, map.getOrDefault(token, 0) + 1);
            }
        }

    }

    private static void displayMap(Map<String, Integer> map) {
        TreeSet<String> sortedSet = new TreeSet<>(map.keySet());


        System.out.println("\nPalavras e suas ocorrências:");
        int duplicates = 0;

        for (String word : sortedSet) {
            int count = map.get(word);
            System.out.println(word + ": " + count);

            if (count > 1) {
                duplicates++;
            }
        }

        System.out.printf("\nNúmero de palavras duplicadas: %d%n", duplicates);
    }
}
