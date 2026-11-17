
import java.util.*;
class Question3{
    static int power(int n , int x)
    {
        int result=1;
        for(int i=1; i<n; i++)
        {
            result=result*x;
        }
        return result;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int n=sc.nextInt();
        System.out.print("Enter Number: ");
        int x=sc.nextInt();
        int ans=power(n, x);
        System.out.print("The Result is : "+ans);

    }
}