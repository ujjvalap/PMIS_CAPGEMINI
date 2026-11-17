
// Exception Handling 

class Sum{
    
    public static void main(String[] args)
    {
        int num1=20;
        int num2=0; 

        try{
            int ans=num1/num2;
            System.out.print(ans);
        }
        catch(ArithmeticException e)
        {
            System.out.print("You can not Divide 0 ");
        }
    }
}