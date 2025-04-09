package Exercicios;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    // Mapa principal como atributo da classe
    private static Map<String, String> dicionario = new HashMap<>();

    public static void main(String[] args) {
        Dici word1 = new Dici("Andar", "Ato de caminhar");
        Dici word2 = new Dici("Sentar", "Ato de repousar em uma cadeira");

        newWord(word1.getPalavra(), word1.getSignificado());
        newWord(word2.getPalavra(), word2.getSignificado());

        // Mostrando o dicionário
        System.out.println("Dicionário:");
        for (Map.Entry<String, String> entry : dicionario.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void newWord(String palavra, String significado) {
        dicionario.put(palavra, significado);
    }

    static class Dici {
        private String palavra;
        private String significado;

        public Dici(String palavra, String significado) {
            this.palavra = palavra;
            this.significado = significado;
        }

        public String getPalavra() {
            return palavra;
        }

        public String getSignificado() {
            return significado;
        }
    }
}