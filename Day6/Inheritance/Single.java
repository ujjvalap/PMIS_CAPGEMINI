
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

public class Single {
    public static void main(String[] args) {
        Dog d = new Dog();

        d.eat();  // Inherited method
        d.bark(); // Own method
    }
}
