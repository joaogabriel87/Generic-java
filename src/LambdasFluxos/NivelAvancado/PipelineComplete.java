import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PipelineComplete {
  public static void main(String[] args) {
    Random random = new Random();
    List<Integer> number = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      number.add(random.nextInt(101));
    }

    System.out.println(number);

    List<Integer> pipeline = number.stream().filter(x -> x % 2 == 0).map(x -> x * 3).sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());

    System.out.println(pipeline);
  }
}
