// package CG_Java_Training.Day11;

// import java.util.stream.Collectors;
// import java.util.*;
// class Lamdaarr {
//     public static void main(String[] args) {
//         List<Integer>nums=Arrays.asList(12 , 35, 23 , 12 , 90  , 34);
//         List<Integer> res=nums.stream()
//         .filter(n->n%2==0)
//         .map(n->n*n)
//         .collect(Collectors.toList());


//         System.out.print(nums);
//     }




// }




package CG_Java_Training.Day11;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.*;
class Lamdaarr {
    public static void main(String[] args) {
        List<Integer>nums=Arrays.asList(12 , 35, 23 , 12 , 90  , 34);
         List<String>Words=Arrays.asList("Mango" , "Apple" , "Banana" , "Kiwi" , "Orange");
        List<String> len=Words.stream()
        .sorted((a,b)-> a.length()- b.length())
        .collect(Collectors.toList());


        List<Integer>res=nums.stream()
        .sorted()
        .collect(Collectors.toList());
        


        System.out.println(len);
        System.out.println(res);
    }




}
