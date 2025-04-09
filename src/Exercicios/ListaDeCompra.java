package Exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaDeCompra {
    public static void main(String[] args) {
        List<String> compras = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String option;


        do {
            System.out.println("\nDigite uma das opções: ");
            System.out.println("1-Adicionar produto");
            System.out.println("2-Remover produto");
            System.out.println("3-Listar compras");
            System.out.println("4-Sair");
            option = sc.nextLine();

            switch (option) {
                case "1":
                        System.out.println("Digite o nome do produto: ");
                        String produto = sc.nextLine();
                        compras.add(produto);
                    break;
                case "2":
                    System.out.println("Itens da lista");
                    for(int i = 0; i < compras.size(); i++){
                        System.out.println(i + " - " + compras.get(i));
                    }
                    System.out.println("Digite o numero do produto que deseja remover: ");
                    int indice = Integer.parseInt(sc.nextLine());
                    compras.remove(indice);
                    System.out.println("O produto removido com sucesso!");
                    break;
                case "3":
                    System.out.println("Lista de compras ");
                    compras.forEach(System.out::println);
                    break;
                case "4":
                    System.out.println("Finalizado com sucesso! ");
                    break;
            }
        }
        while (!option.equals("4"));
        sc.close();
        }
    }


