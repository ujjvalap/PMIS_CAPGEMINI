/**
 * genrices
 * 
 */
import java.util.*;
 class genrices {

    public static void printList(List<?>list)
    {
        for(Object obj : list)
        {
            System.out.println(obj);
        }
    }


    public static  void main(String[] args)
    {
        List<String> name = Arrays.asList("Ujjval", "Ravi" , "Yash");
        List<Integer> age=Arrays.asList(21 , 22 , 24 );
        List<Double>salary=Arrays.asList(29000.5 , 24552.0 , 24523.0);

        System.out.println("\n Name is : ");
        System.out.println(name);

        System.out.println("\n Emp age is :");
        System.out.println(age);

        System.out.println("\n Emp Salary is : ");
        System.out.println(salary);
    }
}