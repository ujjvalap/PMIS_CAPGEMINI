import java.util.*;

public class Main {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("Java");
        list.add(100);
        list.add(10.5);

        String name = (String) list.get(0);

        System.out.println(name);
    }
}