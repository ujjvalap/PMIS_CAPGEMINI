


interface Rentable {
    int calculateRent(int days);
    boolean isAvailable();
}

abstract class Vehicle implements Rentable {

    protected int id;
    protected String model;
    protected double daily_rate;
    protected boolean availability;

    public Vehicle(int id, String model, double daily_rate,
                   boolean availability) {
        this.id = id;
        this.model = model;
        this.daily_rate = daily_rate;
        this.availability = availability;
    }

    @Override
    public abstract int calculateRent(int days);

    @Override
    public boolean isAvailable() {
        return availability;
    }
}

class Bike extends Vehicle {

    public Bike(int id, String model, double daily_rate) {
        super(id, model, daily_rate, true);
    }

    @Override
    public int calculateRent(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException(
                "Days must be greater than zero"
            );
        }

        double rent = daily_rate * days;

        // Apply a 10% discount for rentals of 7 days or more.
        if (days >= 7) {
            rent = rent * 0.90;
        }

        return (int) rent;
    }
}

public class Main {

    public static void main(String[] args) {

        Bike bike = new Bike(1, "Activa", 400);

        System.out.println("Vehicle ID: " + bike.id);
        System.out.println("Model: " + bike.model);
        System.out.println("Daily Rate: " + bike.daily_rate);

        System.out.println("Available: " + bike.isAvailable());

        System.out.println(
            "Rent for 5 days: " + bike.calculateRent(5)
        );

        System.out.println(
            "Rent for 8 days: " + bike.calculateRent(8)
        );
    }
}
