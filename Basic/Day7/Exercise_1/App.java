public class App {
    public static void main(String[] args) {

        Address address = new Address("Bhopal", "Madhya Pradesh", 462001);

        Student student = new Student("Ujjwal", 101, address);

        student.displayDetails();
    }
}