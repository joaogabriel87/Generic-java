package LambdasFluxos.NivelIntermediario;

import java.util.List;

public class CountElement {
  public static void main(String[] args) {
    List<String> word = List.of("Avestruz", "ALicate", "Sport", "Samba", "altar");

    System.out.println(word.stream().map(String::toUpperCase).filter(x -> x.startsWith("A")).count());
  }
}
