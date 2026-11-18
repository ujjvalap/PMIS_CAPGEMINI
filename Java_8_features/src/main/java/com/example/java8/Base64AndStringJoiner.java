import java.util.Base64;
import java.util.StringJoiner;

public class Base64AndStringJoiner {
    public static void main(String[] args) {
        String original = "Hello Java 8";
        String encoded = Base64.getEncoder().encodeToString(original.getBytes());
        String decoded = new String(Base64.getDecoder().decode(encoded));

        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decoded);

        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("Java").add("Spring Boot").add("MySQL");
        System.out.println(joiner);
    }
}
