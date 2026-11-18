interface  Dog{
        void eat();
}

interface Cat{
    void Run();
}


class Animal implements Dog{
  public  void  eat()
  {
    System.out.print("Dog is the Eating ");
  }
}

class pet extends Animal implements Dog{
    public void Run()
    {
        System.out.println("Pet is the Runinig");
    }
}
/**
 * Hybrid
 */
public class Hybrid {
    public static void main(String[] args) {
        pet p=new pet();
        p.Run();
        p.eat();

    }
}