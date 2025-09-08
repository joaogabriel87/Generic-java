import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Pessoa {
  String nome;
  int idade;

  public Pessoa(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  public String tString() {
    return nome + " (" + idade + ")";
  }
}

public class GroupinByEx {
  public static void main(String[] args) {
    Pessoa[] pessoas = {
        new Pessoa("Joao", 20),
        new Pessoa("Gabriel", 35),
        new Pessoa("Oliveira", 56),
        new Pessoa("Feitosa", 12),
        new Pessoa("Nanci", 35)
    };

    List<Pessoa> ListPessoa = Arrays.asList(pessoas);

    Map<Integer, List<Pessoa>> group = ListPessoa.stream().collect(Collectors.groupingBy(Pessoa::getIdade));
    group.forEach((idade, lista) -> System.out.println(idade + "->" + lista));
  }
}
