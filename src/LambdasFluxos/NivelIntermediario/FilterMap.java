package LambdasFluxos.NivelIntermediario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterMap {
  public static void main(String[] args) {

    String[] word = { "Pernambuco", "Sport", "Recife", "Clube", "Gabriel", "joao", "dei", "lua", "sol" };

    // List<String> wordList = Arrays.asList(word);

    System.out
        .println(Arrays.stream(word).filter(x -> x.length() < 4).map(String::toUpperCase).collect(Collectors.toList()));

  }
}
