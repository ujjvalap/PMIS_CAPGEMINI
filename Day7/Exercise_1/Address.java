class Address {
    String city;
    String state;
    int pinCode;

    Address(String city, String state, int pinCode) {
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    void displayAddress() {
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("Pin Code: " + pinCode);
    }
}

class Student {
    String name;
    int rollNumber;
    Address address;

    Student(String name, int rollNumber, Address address) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.address = address;
    }

    void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Address:");

        address.displayAddress();
    }
}

