
//................................................................JAVA OPERATORS.................................


//  class Operators {

//     public static void main(String[] args) {

//         int a = 10;
//         int b = 3;

//         // 1 ARITHMETIC OPERATORS
//         System.out.println(a + b);  // +  Addition      = 13
//         System.out.println(a - b);  // -  Subtraction   = 7
//         System.out.println(a * b);  // *  Multiplication= 30
//         System.out.println(a / b);  // /  Division      = 3
//         System.out.println(a % b);  // %  Modulus       = 1


//         // 2 UNARY OPERATORS
//         int x = 10;

//         System.out.println(+x);     // +x = 10
//         System.out.println(-x);     // -x = -10
//         System.out.println(++x);    // ++x = 11
//         System.out.println(--x);    // --x = 10
//         System.out.println(!true);  // !  = false


//         // 3 RELATIONAL / COMPARISON OPERATORS
//         System.out.println(a == b); // == Equal          = false
//         System.out.println(a != b); // != Not Equal      = true
//         System.out.println(a > b);  // >  Greater        = true
//         System.out.println(a < b);  // <  Less           = false
//         System.out.println(a >= b); // >= Greater/Equal   = true
//         System.out.println(a <= b); // <= Less/Equal      = false


//         // 4.LOGICAL OPERATORS
//         boolean p = true;
//         boolean q = false;

//         System.out.println(p && q); // && AND = false
//         System.out.println(p || q); // || OR  = true
//         System.out.println(!p);     // !  NOT = false


//         // 5 ASSIGNMENT OPERATORS
//         int n = 10;

//         n += 5;  // n = n + 5  = 15
//         n -= 5;  // n = n - 5  = 10
//         n *= 2;  // n = n * 2  = 20
//         n /= 2;  // n = n / 2  = 10
//         n %= 3;  // n = n % 3  = 1

//         System.out.println(n);


//         // 6. BITWISE OPERATORS
//         int c = 5;  // 0101
//         int d = 3;  // 0011

//         System.out.println(c & d);  // & AND = 1
//         System.out.println(c | d);  // | OR  = 7
//         System.out.println(c ^ d);  // ^ XOR = 6
//         System.out.println(~c);     // ~ NOT = -6


//         // . SHIFT OPERATORS
//         int num = 8;

//         System.out.println(num << 1);  // << Left Shift       = 16
//         System.out.println(num >> 1);  // >> Right Shift      = 4
//         System.out.println(num >>> 1); // >>> Unsigned Shift  = 4


//         // 8 TERNARY OPERATOR
//         int age = 20;

//         String result = (age >= 18) ? "Adult" : "Minor";

//         System.out.println(result); // Adult


//         // 9 instanceof OPERATOR
//         String name = "Ujjval";

//         System.out.println(name instanceof String); // true
//     }
// }






//..........................................Java Math.............................................



public class MathExample {
    public static void main(String[] args) {

        // 1 Absolute Value
        System.out.println(Math.abs(-10));      // 10

        // 2 Maximum
        System.out.println(Math.max(10, 20));   // 20

        // 3 Minimum
        System.out.println(Math.min(10, 20));   // 10

        // 4 Square Root
        System.out.println(Math.sqrt(25));      // 5.0

        // 5 Power
        System.out.println(Math.pow(2, 3));     // 8.0

        // 6 Round
        System.out.println(Math.round(10.6));   // 11

        // 7 Ceiling (Round Up)
        System.out.println(Math.ceil(10.2));    // 11.0

        // 8 Floor (Round Down)
        System.out.println(Math.floor(10.8));   // 10.0

        // 9 Random Number (0.0 to < 1.0)
        System.out.println(Math.random());

        // 10 PI
        System.out.println(Math.PI);            // 3.14159...
    }
}