

public class DefaultAndStaticInterfaceMethods {
    interface Vehicle {
        void start();

        default void stop() {
            System.out.println("Vehicle stopped");
        }

        static void serviceInfo() {
            System.out.println("Vehicles need regular service");
        }
    }

    static class Car implements Vehicle {
        public void start() {
            System.out.println("Car started");
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.stop();
        Vehicle.serviceInfo();
    }
}
