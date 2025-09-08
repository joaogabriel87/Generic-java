import java.util.List;

public class reduceString {
  public static void main(String[] args) {

    List<String> nomes = List.of("joao", "jessica", "jamile", "pedro", "gustavo", "leticia", "fernando");
    System.out.println(nomes.stream().reduce((a, b) -> a + "," + b));
  }
}
