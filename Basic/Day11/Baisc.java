package CG_Java_Training.Day11;

import java.util.function.Predicate;

class Baisc {
    public static void main(String[] args) {
        Predicate<Integer> isAdut = age->age>=18;
        System.out.println(isAdut.test(21));
        System.out.println(isAdut.test(15));
    }
}
