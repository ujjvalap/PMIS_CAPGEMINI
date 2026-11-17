

//...........................................Swap the Two Number..............................................
// class Practice{

//     public static void main(String args[])
//     {
//         int a=56;
//         int b=34;

//         // int temp=a;
//         // a=b;
//         // b=temp;

//         // a=a^b;
//         // b=a^b;
//         // a=a^b;

//         a=a+b;
//         b=a-b;
//         a=a-b;

//         System.out.print("Swap Number is : "+ a + " " + b);
//     }

// }



//  Largest Number.
// import java.util.*;
// class Practice{
//     public static void main(String args[])
//     {
//         Scanner sc=new Scanner(System.in);
//         System.out.print("Enter the First Number : ");
//         int a=sc.nextInt();
//          System.out.print("Enter the Seconde Number : ");
//         int b=sc.nextInt();
//          System.out.print("Enter the thard  Number : ");
//         int c=sc.nextInt();

//         if(a>b && a>c)
//         {
//             System.out.print("This is the largest Number: " + a);
//         }

//         else if(b>c && b>a)
//         {
//             System.out.print("This is the largest Number: " + b);
//         }
//         else{
//             System.out.print("This is the largest Number : " + c);
//         }
//     }
// }



//................................................... Find if a year is a leap yera............................................... 

import java.util.*;

class Practice{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Year : ");
        int Year=sc.nextInt();

        if(Year%4==0)
        {
            System.out.print("This Year is leap year : " + Year);
        }

        else{
            System.out.print("This is not leap year" + Year);
        }
    }
}