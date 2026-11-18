package CG_Java_Training.Day5.Encapsulation;


class Student {
    private String name;
    private int age;

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            System.out.println("Name cannot be empty");
        }
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Validater {
    public static void main(String[] args) {
        Student s = new Student();

        s.setName("Ujjwal");
        s.setAge(22);
        s.setAge(-5);

        System.out.println(s.getName());
        System.out.println(s.getAge());
    }
}
