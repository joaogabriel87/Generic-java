package LambdasFluxos.NivelBasico;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionNumber {
  public static void main(String[] args) {
    Function<Integer, String> numeroFrase = n -> "numero é " + n;

    System.out.println(numeroFrase.apply(1));
    System.out.println(numeroFrase.apply(2));
    System.out.println(numeroFrase.apply(3));
    System.out.println(numeroFrase.apply(4));
    System.out.println(numeroFrase.apply(5));
    System.out.println(numeroFrase.apply(6));
  }
}
