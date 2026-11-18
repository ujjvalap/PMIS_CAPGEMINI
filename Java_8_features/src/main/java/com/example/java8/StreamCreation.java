
import java.util.*;
import java.util.stream.*;

public class StreamCreation {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(10, 20, 30);
        values.stream().forEach(System.out::println);

        Stream.of("Java", "Spring", "SQL").forEach(System.out::println);
        Arrays.stream(new int[]{1, 2, 3}).forEach(System.out::println);
        Stream.<String>empty().forEach(System.out::println);

        Stream.iterate(1, n -> n + 1).limit(5).forEach(System.out::println);
        Stream.generate(() -> "Hello").limit(3).forEach(System.out::println);
    }
}
