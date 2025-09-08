package LambdasFluxos.NivelBasico;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerList {
  public static void main(String[] args) {
    List<Double> listDouble = List.of(1.1, 2.2, 3.3, 4.5, 5.5);

    Consumer<Double> consumerDouble = (x) -> System.out.println(x * 2);

    listDouble.forEach(x -> {
      consumerDouble.accept(x);
      ;
    });
  }
}
