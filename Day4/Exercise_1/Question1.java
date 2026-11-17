//..............................................Enter 3 numbers from the user & make a function to print their average. 
import java.util.*;

class Question1 {

    // Function to calculate average
    static int calculateAverage(int num1, int num2, int num3) {
        int avg = (num1 + num2 + num3) / 3;
        return avg;
    }

    public static void main(String[] args) {

        // Take input from user
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the First Number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter the Second Number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter the Third Number: ");
        int num3 = sc.nextInt();

        // Call the function
        int avg = calculateAverage(num1, num2, num3);

        System.out.println("Avg of the Numbers is: " + avg);

        sc.close();
    }
}