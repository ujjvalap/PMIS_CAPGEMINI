/**
 * Hierarchical
 */

class Animal{

    void eat()
    {
        System.out.println("Aninmal is eat the Food");
    }
}

// This is child class 1 
class  Dog extends Animal{
    void barking()
    {
        System.out.println("Dog is the barking ");
    }
}

// This is child class 1 
class Cat extends  Animal{
    void meow(){
        System.out.print("Cat is meow ");
    }
}
/**
 * Hierarchical
 */
public class Hierarchical {
    public static void main(String[] args)
    {
        Dog obj1=new Dog();
        Cat obj2=new Cat();

        obj1.eat();
        obj1.barking();

        obj2.eat();
        obj2.meow();
    }
}