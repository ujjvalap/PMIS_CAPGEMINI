package CG_Java_Training.Day11;

import  java.util.function.*;
public class Funcation {
    
    public static void main(String[] args) {
        Function<String,Integer>getLen= name-> name.length();
        System.out.println(getLen.apply("Ravi"));
        System.out.println(getLen.apply("Ujjval"));
    }
}
