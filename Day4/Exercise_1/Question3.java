// Write a function which takes in 2 numbers and returns the greater of those two. 

import java.util.*;

class Question3 {

    static int greaterNumber(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter Second Number: ");
        int num2 = sc.nextInt();

        int greater = greaterNumber(num1, num2);

        System.out.println("Greater Number is: " + greater);

        sc.close();
    }
}