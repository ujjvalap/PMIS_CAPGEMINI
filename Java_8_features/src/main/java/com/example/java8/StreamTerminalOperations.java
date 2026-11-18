
import java.util.*;
import java.util.stream.*;

public class StreamTerminalOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        System.out.println("Count: " + numbers.stream().count());
        System.out.println("Sum: " + numbers.stream().reduce(0, Integer::sum));
        System.out.println("Min: " + numbers.stream().min(Integer::compareTo).get());
        System.out.println("Max: " + numbers.stream().max(Integer::compareTo).get());
        System.out.println("First: " + numbers.stream().findFirst().get());
        System.out.println("Any match > 40: " + numbers.stream().anyMatch(n -> n > 40));
        System.out.println("All positive: " + numbers.stream().allMatch(n -> n > 0));
        System.out.println("None negative: " + numbers.stream().noneMatch(n -> n < 0));

        List<Integer> filtered = numbers.stream().filter(n -> n >= 30)
                .collect(Collectors.toList());
        System.out.println("Collected: " + filtered);
    }
}
