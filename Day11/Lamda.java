
package CG_Java_Training.Day11;
import  java.util.*;
@FunctionalInterface
/**
 * Basic
 */
 interface Greeat {

    void greet(String name);
}

/**
 * InnerGreeat
 */
public class Lamda{

    public static  void  main(String[] args)
    {
        Greeat g = name-> System.out.println("Name is : " + name);
        g.greet("Ujjval");
    }
    
}