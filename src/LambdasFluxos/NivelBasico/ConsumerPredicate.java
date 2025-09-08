package LambdasFluxos.NivelBasico;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

class Nomes {
  private String nome;

  public Nomes(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nomeString) {
    this.nome = nomeString;
  }

  public String toString() {
    return nome;
  }

}

public class ConsumerPredicate {
  // public static Boolean ePar(Integer number) {
  // Predicate<Integer> par = x -> x % 2 == 0;

  // return par.test(number);
  // }

  public static void main(String[] args) {
    Nomes[] nomes = {
        new Nomes("Joao"),
        new Nomes("Gabriel"),
        new Nomes("Oliveira"),
        new Nomes("Feitosa")
    };
    Consumer<Nomes> imprimir = x -> System.out.println(x);
    for (int i = 0; i < nomes.length; i++) {
      imprimir.accept(nomes[i]);
    }
    ;
    List<Integer> numbers = List.of(10, 5, 20, 11, 13);

    Predicate<Integer> ePar = x -> x % 2 == 0;

    for (Integer num : numbers) {
      System.out.println(ePar.test(num));
    }
  }
}
