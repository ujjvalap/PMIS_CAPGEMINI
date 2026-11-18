package CG_Java_Training.Day5.Encapsulation;



class Student {
    // Private data members
    private String name;
    private int age;

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();

        s.setName("Ujjwal");
        s.setAge(22);

        System.out.println("Name: " + s.getName());
        System.out.println("Age: " + s.getAge());
    }
}

