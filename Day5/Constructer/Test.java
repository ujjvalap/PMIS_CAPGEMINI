class Test{

    String Brand;
    String color;
    int Speed;

    public Test(String Brand , String color , int Speed)
    {
        this.Brand=Brand;
        this.color=color;
        this.Speed=Speed;
    }

     void Dispayitem()
    {
        System.out.println("Car Brnad is : "+ Brand + " Color is : " + color + "speed is  " + Speed);
    }

     void run(int n )
    {
        Speed+=n;
        System.out.print(Speed);
        
    }

    public static void main(String[] args)
    {
        Test obj=new Test("BMW" , "Balck" ,200);
        obj.Dispayitem();
        obj.run(200);
         
    }
}