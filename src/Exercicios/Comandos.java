package Exercicios;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Comandos {
    private static final int capacidade_maxima = 5;
    private static Deque<String> historico = new ArrayDeque<>(capacidade_maxima);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String comando;

        System.out.println("Digite comandos(ou 'sair' para terminar)");
        while(!(comando = sc.nextLine()).equalsIgnoreCase("sair")) {
            if(!comando.trim().isEmpty()) {
                adicionarcomando(comando);
                System.out.println("Historico: " + historico);
            }
        }
        sc.close();
    }

    private static void adicionarcomando(String comando) {
        if(historico.size() >= capacidade_maxima) {
            historico.removeLast();
        }
        historico.addFirst(comando);
    }

}
