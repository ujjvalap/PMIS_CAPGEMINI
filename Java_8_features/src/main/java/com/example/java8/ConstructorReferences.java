
import java.util.*;
import java.util.function.*;

public class ConstructorReferences {
    static class Student {
        private final String name;
        Student(String name) { this.name = name; }
        public String toString() { return "Student{name='" + name + "'}"; }
    }

    public static void main(String[] args) {
        Function<String, Student> studentFactory = Student::new;
        Student student = studentFactory.apply("Ujjwal");
        System.out.println(student);

        Supplier<List<String>> listFactory = ArrayList::new;
        List<String> names = listFactory.get();
        names.add("Aman");
        names.add("Rahul");
        System.out.println(names);
    }
}
