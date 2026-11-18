
class Student {
    final int rollNumber;
    String name;

    Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    void display() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
    }
}

class FinalKeyword {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Rahul");
        s1.display();
    }
}
