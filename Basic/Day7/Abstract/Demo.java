package CG_Java_Training.Day7.Abstract;

public class Demo {
    public static void main(String[] args) {

        Car obj=new Petrolcar();
        obj.Start();
        obj.accu();
        obj.Break();

   
        Car obj1=new elctricCar();
        obj1.Start();
        obj1.accu();
        obj1.Break();
        
    }
}


abstract class Car{

    void Start()
    {
        System.out.println("Car is Started.............");
    }

     abstract void accu();

     abstract void Break();
   
}

class elctricCar extends  Car{

    @Override 
    void accu()
    {
        System.out.println("Electric Car is Run ");
    }

    @Override 
    void Break()
    {
        System.out.println("Apply the Break");
    }
}


class Petrolcar extends  Car{

    @Override 
    void accu()
    {
        System.out.println("Petrolcar Car is Run ");
    }

    @Override 
    void Break()
    {
        System.out.println("Petrolcar the Break");
    }
}