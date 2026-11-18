
import java.util.function.*;

public class MethodReferences {
    public static void main(String[] args) {
        // Static method reference
        Function<String, Integer> parser = Integer::parseInt;
        System.out.println(parser.apply("123"));

        // Instance method reference on a particular object
        Consumer<String> printer = System.out::println;
        printer.accept("Hello from System.out::println");

        // Instance method reference on an arbitrary object of a type
        Function<String, String> upperCase = String::toUpperCase;
        System.out.println(upperCase.apply("java"));

        // Constructor reference
        Supplier<StringBuilder> builderFactory = StringBuilder::new;
        System.out.println(builderFactory.get().append("Created").toString());
    }
}
