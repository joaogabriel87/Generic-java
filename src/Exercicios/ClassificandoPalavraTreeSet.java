package Exercicios;

import java.util.*;

public class ClassificandoPalavraTreeSet {
    public static void main(String[] args){
          Scanner sc = new Scanner(System.in);
          Set<String> set = new TreeSet<>();

          System.out.println("Digite uma palavra: ");
          String palavra = sc.nextLine().toLowerCase();

          String[] palavras = palavra.split(" ");

          for (String word : palavras) {
              if(!word.isEmpty()){
              set.add(word);
              }
          }

          System.out.println("\nPalavras ordenadas");
          for (String word : set) {
              System.out.println(word);
          }
    }




}
