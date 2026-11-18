import java.util.*;

class Question4 {

    static double circumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the radius: ");
        double radius = sc.nextDouble();

        double result = circumference(radius);

        System.out.println("Circumference of the circle: " + result);

        sc.close();
    }
}