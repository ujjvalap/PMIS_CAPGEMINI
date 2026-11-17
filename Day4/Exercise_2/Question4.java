// GCD Print 

import java.util.*;
class Question4 {
    
    static int GCD(int x, int y)
    { 
            while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
        
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the First Number : ");
        int x=sc.nextInt();
        System.out.print("Enter the Seconde Numner: ");
        int y=sc.nextInt();
        
        int Gcd=GCD(x, y);
        System.out.print("GCD of the Number is :  " + Gcd);
        
    }
}