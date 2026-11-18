import java.util.*;
import java.util.stream.*;

public class StreamPipelineAndLazyEvaluation {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4);

        Stream<Integer> pipeline = values.stream()
                .filter(n -> {
                    System.out.println("Filtering " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("Mapping " + n);
                    return n * 10;
                });

        System.out.println("No terminal operation yet: pipeline has not run.");
        pipeline.forEach(System.out::println);
    }
}
