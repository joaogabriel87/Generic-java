package Exercicios;

import java.util.HashSet;
import java.util.Set;

public class OperacoesConjuntos {
    public static void main(String[] args) {
        // Criando os conjuntos
        Set<String> conjuntoA = new HashSet<>();
        Set<String> conjuntoB = new HashSet<>();

        conjuntoA.add("Java");
        conjuntoA.add("Python");
        conjuntoA.add("C++");

        conjuntoB.add("Python");
        conjuntoB.add("JavaScript");
        conjuntoB.add("Ruby");

        // União
        Set<String> uniao = new HashSet<>(conjuntoA);
        uniao.addAll(conjuntoB);
        System.out.println("União: " + uniao);

        // Interseção
        Set<String> intersecao = new HashSet<>(conjuntoA);
        intersecao.retainAll(conjuntoB);
        System.out.println("Interseção: " + intersecao);

        // Diferença (A - B)
        Set<String> diferenca = new HashSet<>(conjuntoA);
        diferenca.removeAll(conjuntoB);
        System.out.println("Diferença (A - B): " + diferenca);
    }
}