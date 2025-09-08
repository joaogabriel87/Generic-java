import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamsEx {
  public static void main(String[] args) {
    List<Integer> numeros = IntStream.rangeClosed(1, 200_000_000)
        .boxed()
        .collect(Collectors.toList());

    // STREAM SEQUENCIAL
    long inicioSeq = System.currentTimeMillis();

    long somaSeq = numeros.stream()
        .mapToLong(Integer::longValue)
        .sum();

    long fimSeq = System.currentTimeMillis();

    System.out.println("Soma Sequencial: " + somaSeq +
        " | Tempo: " + (fimSeq - inicioSeq) + " ms");

    // STREAM PARALELO
    long inicioPar = System.currentTimeMillis();

    long somaPar = numeros.parallelStream()
        .mapToLong(Integer::longValue)
        .sum();

    long fimPar = System.currentTimeMillis();

    System.out.println("Soma Paralela: " + somaPar +
        " | Tempo: " + (fimPar - inicioPar) + " ms");
  }
}
