
import java.util.*;
import java.util.stream.*;

public class StreamIntermediateOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 3, 2, 8, 10, 12);

        System.out.println("filter + map:");
        numbers.stream().filter(n -> n > 5).map(n -> n * 2)
                .forEach(System.out::println);

        System.out.println("distinct + sorted:");
        numbers.stream().distinct().sorted().forEach(System.out::println);

        System.out.println("descending:");
        numbers.stream().distinct().sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("skip + limit:");
        numbers.stream().skip(2).limit(3).forEach(System.out::println);

        System.out.println("peek (debugging):");
        numbers.stream().filter(n -> n > 5)
                .peek(n -> System.out.println("After filter: " + n))
                .map(n -> n + 100).forEach(System.out::println);
    }
}
