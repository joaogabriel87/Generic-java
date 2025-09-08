import java.util.List;

public class MaioreMenor {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    int maior = numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
    int menor = numbers.stream().reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);

    System.out.println("Menor " + menor);
    System.out.println("Maior " + maior);

  }
}
