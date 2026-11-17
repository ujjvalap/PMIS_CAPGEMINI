// Write a function that takes in age as input and returns if that person is eligible to vote or not. A person of age > 18 is eligible to vote. 

import java.util.*;

class Question5 {

    static boolean isEligibleToVote(int age) {
        if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        boolean result = isEligibleToVote(age);

        if (result) {
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }

        sc.close();
    }
}