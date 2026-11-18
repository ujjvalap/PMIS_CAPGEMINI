
import java.util.*;

public class ParallelStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Output order is not guaranteed with parallel forEach.
        numbers.parallelStream().forEach(n ->
                System.out.println(n + " on " + Thread.currentThread().getName()));

        // Preserves encounter order, although processing may be parallel.
        numbers.parallelStream().forEachOrdered(System.out::println);

        int sum = numbers.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println("Parallel sum: " + sum);
    }
}
