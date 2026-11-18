// HAS-A relationship

class Engine {
    void start() {
        System.out.println("Engine is starting");
    }
}

class Car {
    private Engine engine;

    Car() {
        engine = new Engine();
    }

    void drive() {
        engine.start();
        System.out.println("Car is moving");
    }
}

public class Test1 {
    public static void main(String[] args) {
        Car c = new Car();
        c.drive();
    }
}

