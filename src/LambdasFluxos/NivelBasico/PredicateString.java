package LambdasFluxos.NivelBasico;

import java.util.List;
import java.util.function.Predicate;

public class PredicateString {
  public static void main(String[] args) {
    List<String> words = List.of("abraçar", "Beijar", "saltar", "fechar", "sol", "Lua");
    Predicate<String> verifyString = x -> x.length() > 5;

    words.forEach(x -> {
      System.out.println(verifyString.test(x));
    });
  }
}
