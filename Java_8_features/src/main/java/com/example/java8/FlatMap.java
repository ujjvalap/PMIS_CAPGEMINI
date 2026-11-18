
import java.util.*;
import java.util.stream.*;

public class FlatMap {
    public static void main(String[] args) {
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> flattened = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(flattened);
    }
}
