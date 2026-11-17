

class Animal{
    void Sound()
    {
        System.out.print("Animal Sound");
    }
}

class Dog extends Animal{
    @Override
    void Sound()
    {
        System.out.println("Dog Sound");
    }
}

/**
 * Overiding
 */
public class Overiding {

    public static void main(String[] args) {
        Dog obj=new Dog();
        obj.Sound();
    }
}