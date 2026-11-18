
import java.util.*;

public class ForEach {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ujjwal", "Rahul", "Aman");
        names.forEach(name -> System.out.println(name));

        Map<Integer, String> users = new HashMap<Integer, String>();
        users.put(1, "Ujjwal");
        users.put(2, "Rahul");
        users.forEach((id, name) -> System.out.println(id + " -> " + name));
    }
}
