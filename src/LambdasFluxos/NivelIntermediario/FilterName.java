package LambdasFluxos.NivelIntermediario;

import java.util.List;

public class FilterName {
  public static void main(String[] args) {

    List<String> nomes = List.of("joao", "jessica", "jamile", "pedro", "gustavo", "leticia", "fernando");
    System.out.println(nomes.stream().filter(x -> x.startsWith("j")).map(String::toUpperCase).toList());
  }
}
