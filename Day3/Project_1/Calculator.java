import java.util.*;

class Calculator{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Please Select The Triangle (1-3): ");
        int T = sc.nextInt();

        if (T == 1) {
            System.out.println("This is Triangle 1");

            System.out.print("Enter base: ");
            double b = sc.nextDouble();

            System.out.print("Enter height: ");
            double h = sc.nextDouble();

            double ans = 0.5 * b * h;

            System.out.println("Area of Triangle " + ans);
        }

        else if (T == 2) {
            System.out.println("This is Triangle 2");

            System.out.print("Enter Side : ");
            double a = sc.nextDouble();

            double area = a * a;

            System.out.println("Area of Square " + area);
        }

        else if (T == 3) {
            System.out.println("This is Triangle 3");

            System.out.print("Enter length: ");
            double l = sc.nextDouble();

            System.out.print("Enter breadth: ");
            double b = sc.nextDouble();

            double area = l * b;

            System.out.println("Area  " + area);
        }

        else {
            System.out.println("Invalid Input Please select a number from 1 to 3.");
        }

        sc.close();
    }
}