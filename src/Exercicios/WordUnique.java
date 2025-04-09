package Exercicios;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class WordUnique {
    public static void main(String[] args) {
        String text = "Quem sou eu?\n" +
                "Não sei quem sou quando estou com você\n" +
                "Me sinto artista de cinema\n" +
                "Esqueço de qualquer problema\n" +
                "Onde está?\n" +
                "O meu juízo aonde foi parar?\n" +
                "Perco o sentido é só você chegar\n" +
                "Com essa vontade de me namorar";
        Set<String> set = new HashSet<>();

        String[] token = text.toLowerCase().split(" ");

        for (String word : token) {
            set.add(word);
        }
        System.out.println("Palavras unicas");
        for (String word : set) {
            System.out.println(word);
        }
    }

}
