package LambdasFluxos.NivelIntermediario;

import java.util.List;

public class ContagemCondicao {
  public static void main(String[] args) {
    List<String> words = List.of("Arroz", "feijao", "Lista", "casal", "tempo", "abacaxi", "Lista", "Lista");
    long count = words.stream().filter(x -> x.endsWith("a")).count();
    System.out.println(count);
  }
}
