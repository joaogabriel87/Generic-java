package Exercicios;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AgendaTelefonica {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Integer, String> telefonica = new TreeMap<>();
        String numero;

        do {
            System.out.println("\nDigite uma das opções: ");
            System.out.println("1-Adicionar contato");
            System.out.println("2-Remover contato");
            System.out.println("3-Buscar contato");
            System.out.println("4-Sair");
            numero = sc.nextLine();

            switch (numero) {
                case "1":
                    addTelefonica(telefonica);
                    break;
                case "2":
                    removeTelefonica(telefonica);
                    break;
                case "3":
                    getName(telefonica);
                    break;
                case "4":
                    System.out.println("Finalizado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (!numero.equals("4"));

        sc.close();
    }

    public static void addTelefonica(Map<Integer, String> telefonica) {
        System.out.println("Digite o nome do contato:");
        String name = sc.nextLine();
        System.out.println("Digite o número:");
        int number = Integer.parseInt(sc.nextLine());
        telefonica.put(number, name);
        System.out.println("Contato adicionado com sucesso!");
    }

    public static void removeTelefonica(Map<Integer, String> telefonica) {
        System.out.println("Contatos existentes:\n" + telefonica);
        System.out.println("Digite qual número você vai remover:");
        int number = Integer.parseInt(sc.nextLine());
        if (telefonica.remove(number) != null) {
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Número não encontrado!");
        }
    }

    public static void getName(Map<Integer, String> telefonica) {
        System.out.println("Digite o número para buscar:");
        int number = Integer.parseInt(sc.nextLine());
        String nome = telefonica.get(number);
        if (nome != null) {
            System.out.println("Contato encontrado: " + nome);
        } else {
            System.out.println("Número não encontrado!");
        }
    }
}