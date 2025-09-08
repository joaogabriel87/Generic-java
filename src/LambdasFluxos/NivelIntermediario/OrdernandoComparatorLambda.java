package LambdasFluxos.NivelIntermediario;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

class Pessoa {
  public String Nome;
  public int idade;

  public Pessoa(String nome, int idade) {
    this.Nome = nome;
    this.idade = idade;
  }

  public int getIdade() {
    return idade;
  }

  public String toString() {
    return idade + "idade";
  }
}

public class OrdernandoComparatorLambda {
  public static void main(String[] args) {
    Pessoa[] pessoas = {
        new Pessoa("JOAO", 22),
        new Pessoa("Gabriel", 19),
        new Pessoa("Lucas", 25),
        new Pessoa("Carlos", 39),
        new Pessoa("Pedro", 15),
        new Pessoa("Nanci", 55)
    };

    List<Pessoa> list = Arrays.asList(pessoas);

    Function<Pessoa, Integer> idade = Pessoa::getIdade;

    Comparator<Pessoa> orderIdade = Comparator.comparing(idade);

    list.stream().sorted(orderIdade).forEach(System.out::println);

  }
}
