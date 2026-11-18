
import java.util.Optional;

public class Optional {
    public static void main(String[] args) {
        java.util.Optional<String> present = java.util.Optional.of("Ujjwal");
        java.util.Optional<String> nullable = java.util.Optional.ofNullable(null);
        java.util.Optional<String> empty = java.util.Optional.empty();

        System.out.println(present.get());
        System.out.println(nullable.orElse("Default User"));
        System.out.println(empty.isPresent());

        present.ifPresent(value -> System.out.println("Value: " + value));

        String upper = present.map(String::toUpperCase).orElse("UNKNOWN");
        System.out.println(upper);

        String result = nullable.orElseGet(() -> "Generated default");
        System.out.println(result);

        try {
            empty.orElseThrow(() -> new IllegalStateException("No value present"));
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
