package LambdasFluxos.NivelBasico;

import java.util.function.Supplier;

public class ExSupplier {
  public static void main(String[] args) {
    Supplier<Double> randomNumber = () -> Math.random();
    System.out.println(randomNumber.get());
  }
}
