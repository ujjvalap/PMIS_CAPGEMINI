import java.util.stream.*;

public class PrimitiveStreams {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 10).sum();
        int max = IntStream.of(4, 8, 2, 9).max().getAsInt();
        double average = IntStream.of(10, 20, 30).average().getAsDouble();

        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Average: " + average);

        LongStream.of(100L, 200L).forEach(System.out::println);
        DoubleStream.of(1.5, 2.5).forEach(System.out::println);
    }
}
