package CG_Java_Training.Day7.Abstract;

public class Concrete {
    public static void main(String[] args) {
        Dog obj=new Dog();
        obj.Eat();
    }
}


abstract class Animal{
    void Eat()
    {
        System.out.println("Dog is eat Bon...............?");
    }
}

class Dog extends Animal{

}


