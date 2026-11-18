// package CG_Java_Training.Day11;

// import  java.util.function.*;
// public class Squar {
//     public static void main(String[] args) {
//         Function<Integer , Integer >sqr = length->length*length;
//         System.out.println(sqr.apply(12));
         
//     }
// }



// package CG_Java_Training.Day11;

// import  java.util.function.*;
// public class Squar {
//     public static void main(String[] args) {
//         Consumer<String> print = msg->System.out.println(msg);
//         print.accept("I love Chess ");
         
//     }
// }






// package CG_Java_Training.Day11;

// import  java.util.function.*;
// public class Squar {
//     public static void main(String[] args) {
//         Supplier<String> msg=()->"Hello ";
//         System.out.println(msg.get());
       
         
//     }
// }






package CG_Java_Training.Day11;

import  java.util.function.*;
public class Squar {
    public static void main(String[] args) {
        Consumer <String> PhoneNumber = number ->{
            System.out.println("The User Phone Number is : " + number);
        };

        PhoneNumber.accept("+91 8435423244");

       
         
    }
}
