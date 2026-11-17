package CG_Java_Training.Day7.Abstract;

public class Recipt {
    public static void main(String[] args) { 
        Payment obj=new Upipayment();
        obj.recipt();
        obj.pay(15000);

    }
}

 abstract class Payment{
    abstract void pay(double amount);

    void recipt()
    {
        System.out.println("Payment Recipt is Genrated.........?");
    }
  
}


class Upipayment extends  Payment{
    
    @Override 
    void pay(double amount)
    {
        System.out.println("Paid the Amount Via UPI : " + amount);
    }

}