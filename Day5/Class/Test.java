// class Test{
//     String name="Ujjval";
//     int age=21;

//     public static void main(String[] args)
//     {
//         Test obj=new Test();
//         System.out.println("My name is : " + obj.name);
//         System.out.println("I am " + obj.age + " Old");
//     }
// }



// Multiple Object

// class Test{
//     String name="Ujjval";
//     int age=21;

//     public static void main(String[] args)
//     {
//         Test obj1=new Test();
//         Test obj2=new Test();
//         System.out.println("My Name is : " + obj1.name);
//         System.out.println( "I am : " + obj2.age + "old");
//     }
// }


// Multiple Class 

// class Main{
//     int x=5;
// }

// class Test{
//     public static void main(String[] args)
//     {
//         Main obj=new Main();
//         System.out.print(obj.x);
//     }
// }


// Attribute Modify 


// class Main{
//     int x=5;
// }

// class Test{
//     public static void main(String[] args)
//     {
//         Main obj=new Main();
//         obj.x=2345; // This is the msg 
//         System.out.print(obj.x);
//     }
// }



// Class Acess in the Method

class Test{

     static void Brand()
     {
        System.out.println("Brand is BMW ");

     }

     static int Speed(int s)
     {
        return s;
     }


     public static void main(String[] args)
     {
        Test obj=new Test();
        obj.Brand();
        System.out.println(obj.Speed(200));
     }
}