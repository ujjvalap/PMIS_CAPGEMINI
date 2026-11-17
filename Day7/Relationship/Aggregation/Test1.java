// Weak HAS-A Relationship 


class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class Student {
    String name;
    Address address;

    Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    void display() {
        System.out.println(name + " lives in " + address.city);
    }
}

public class Test1 {
    public static void main(String[] args) {
        Address a = new Address("Bhopal");
        Student s = new Student("Yash", a);

        s.display();
    }
}
