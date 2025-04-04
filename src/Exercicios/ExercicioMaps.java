package Exercicios;

import java.util.*;

public class ExercicioMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new TreeMap<>();

        crateMap(map1);
        displayMap(map1);

    }

    public static void crateMap(Map<String, Integer> map){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String input = scanner.nextLine().toLowerCase();

        for(char c: input.toCharArray()){
            if(Character.isLetter(c)){
                String letter = String.valueOf(c);
                map.put(letter, map.getOrDefault(letter, 0) + 1);
            }
        }
    }
    public static void displayMap(Map<String, Integer> map){
        System.out.printf("%nMapa de ocorrências:%n%-10s%10s%n", "Letra", "Frequência");

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.printf("%-10s%10d%n", entry.getKey(), entry.getValue());
        }

        System.out.printf("%nTotal de letras únicas: %d%nMapa está vazio: %b%n", map.size(), map.isEmpty());
        }

    }

