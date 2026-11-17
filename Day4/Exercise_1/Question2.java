// Write a function to print the sum of all odd numbers from 1 to n.

import java.util.*;

class Question2 {

    // Function to calculate sum of odd numbers
    static int Sum(int n) {
        int sum = 0;

        for (int i = 1; i < n; i+=2) {
        
              sum += i;
            
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number: ");
        int n = sc.nextInt();

        int sum = Sum(n);

        System.out.println("Sum of odd numbers: " + sum);

        sc.close();
    }
}