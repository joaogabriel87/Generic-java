package LambdasFluxos.NivelIntermediario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class QuadradoDistintos {
  public static void main(String[] args) {
    Random random = new Random();
    List<Integer> numbIntegers = new ArrayList();

    for (int i = 0; i < 10; i++) {
      numbIntegers.add(random.nextInt(26));
    }

    System.out.println(numbIntegers);

    System.out.println(numbIntegers.stream().map(x -> x * x).distinct().toList());

  }
}
