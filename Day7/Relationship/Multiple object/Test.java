// Multiple Object Associations HAS A Relationship in Java
class Battery {
    int capacity;

    Battery(int capacity) {
        this.capacity = capacity;
    }

    void showBattery() {
        System.out.println("Battery capacity: " + capacity + " mAh");
    }
}

class Camera {
    int megapixels;

    Camera(int megapixels) {
        this.megapixels = megapixels;
    }

    void takePhoto() {
        System.out.println("Taking photo with " + megapixels + " MP camera");
    }
}

class Phone {
    String brand;
    Battery battery;
    Camera camera;

    Phone(String brand, Battery battery, Camera camera) {
        this.brand = brand;
        this.battery = battery;
        this.camera = camera;
    }

    void showDetails() {
        System.out.println("Phone brand: " + brand);

        battery.showBattery();
        camera.takePhoto();
    }
}

public class Test {
    public static void main(String[] args) {

        Battery b = new Battery(5000);
        Camera c = new Camera(50);

        Phone p = new Phone("Motorola", b, c);

        p.showDetails();
    }
}
