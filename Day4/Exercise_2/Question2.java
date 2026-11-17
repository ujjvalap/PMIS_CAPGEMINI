//  Write a program to enter the numbers till the user wants and at the end it should display the count of positive, negative and zeros entered.  

import java.util.*;

class Question2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int positive = 0;
        int negative = 0;
        int zero = 0;
       
        System.out.print("Enter a number: ");
           int num = sc.nextInt();

            if (num > 0) {
                positive++;
            } else if (num < 0) {
                negative++;
            } else {
                zero++;
            }
        
        System.out.println("/n Result");
        System.out.println("Positive numbers: " + positive);
        System.out.println("Negative numbers: " + negative);
        System.out.println("Zeros: " + zero);
    }
}