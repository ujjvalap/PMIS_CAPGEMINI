
package CG_Java_Training.Day7.Abstract;

interface Run {
    void Start();

    void Accu();

    void Break();
}

class ElectricCar implements Run {

    @Override
    public void Start() {
        System.out.println("Electric car is started...");
    }

    @Override
    public void Accu() {
        System.out.println("Electric car is accelerating...");
    }

    @Override
    public void Break() {
        System.out.println("Electric car is braking...");
    }
}

class PetrolCar implements Run {

    @Override
    public void Start() {
        System.out.println("Petrol car is started...");
    }

    @Override
    public void Accu() {
        System.out.println("Petrol car is accelerating...");
    }

    @Override
    public void Break() {
        System.out.println("Petrol car is braking...");
    }
}

public class Interface {

    public static void main(String[] args) {

        ElectricCar obj = new ElectricCar();
        obj.Start();
        obj.Accu();
        obj.Break();

        System.out.println("----------------");

        PetrolCar obj1 = new PetrolCar();
        obj1.Start();
        obj1.Accu();
        obj1.Break();
    }
}
