
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Predicate<Integer> isAdult = age -> age >= 18;
        Function<String, Integer> length = String::length;
        Consumer<String> printer = System.out::println;
        Supplier<String> message = () -> "Welcome to Java 8";
        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        UnaryOperator<Integer> square = n -> n * n;
        BinaryOperator<Integer> max = Integer::max;

        System.out.println(isAdult.test(21));
        System.out.println(length.apply("Java"));
        printer.accept(message.get());
        System.out.println(isGreater.test(10, 5));
        System.out.println(add.apply(10, 20));
        System.out.println(square.apply(5));
        System.out.println(max.apply(12, 30));
    }
}
