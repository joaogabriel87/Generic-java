package LambdasFluxos.NivelIntermediario;

import java.util.Comparator;
import java.util.List;

public class OrdernaComprimento {
  public static void main(String[] args) {
    List<String> words = List.of("Arroz", "feijao", "Lista", "casal", "tempo", "abacaxi");

    System.out.println(words.stream().sorted(Comparator.comparingInt(String::length)).toList());
  }
}
