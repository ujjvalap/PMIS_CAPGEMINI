
    import java.util.*;
    class  Question5{
        static  int Fibonacci(int n) 
        {
            if(n==0 || n==1)
            {
                return 1;
            }
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
         public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter the Number : ");
            int n=sc.nextInt();
            System.out.print("Series is :" + Fibonacci(n));
                
        }

    }