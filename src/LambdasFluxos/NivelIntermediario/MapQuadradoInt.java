package LambdasFluxos.NivelIntermediario;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MapQuadradoInt {
  public static void main(String[] args) {
    List<Integer> number1 = List.of(1, 2, 3, 4, 5, 6, 7, 8);
    List<Integer> number2 = number1.stream().map(n -> n * n).collect(Collectors.toList());

    System.out.println(number2);
  }
}
