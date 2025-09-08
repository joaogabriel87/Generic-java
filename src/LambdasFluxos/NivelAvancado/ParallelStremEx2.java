import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStremEx2 {
  public static void main(String[] args) {
    List<Integer> numbers = IntStream.range(1, 20_000_000).boxed().collect(Collectors.toList());

    long inicioSeq = System.currentTimeMillis();

    long somaSeq = numbers.stream().mapToLong(x -> (long) x * x).sum();

    long fimSeq = System.currentTimeMillis();

    System.out.println("Soma Sequencial: " + somaSeq +
        " | Tempo: " + (fimSeq - inicioSeq) + " ms");

    long inicioPar = System.currentTimeMillis();

    long somaPar = numbers.parallelStream().mapToLong(x -> (long) x * x).sum();

    long fimPar = System.currentTimeMillis();

    System.out.println("Soma Paralela: " + somaPar +
        " | Tempo: " + (fimPar - inicioPar) + " ms");
  }
}
