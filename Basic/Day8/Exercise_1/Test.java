// package CG_Java_Training.Day8.Exercise_1;
import java.util.*;

class Test {
  
    public static void main(String[] args) {
       
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the First Number : ");
        int num1=sc.nextInt();
        System.out.println("Enter the Seconde Number : ");
        int num2=sc.nextInt();

       
        try {
            int ans=num1/num2;
            System.out.println("The Number is Divide By " + ans);
        } catch (ArithmeticException e) {
            System.out.println("Number is Not Divide By Zero  ");
            System.out.println(e.getMessage());
        }

    }
    
}
