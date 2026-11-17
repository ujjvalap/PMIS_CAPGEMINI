package CG_Java_Training.Day7.Abstract;


abstract class Animal{
    Animal()
    {
        System.out.println("Animal constrcuter ");
    }
}

class Dog extends Animal{
    Dog()
    {
        System.out.println("Dog constrcuter ");
    }
}


public class Abstract {
    
    public static void main(String[] args) {
        Dog obj=new Dog();
    }
}

