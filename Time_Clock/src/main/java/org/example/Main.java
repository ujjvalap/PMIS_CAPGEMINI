package CG_Java_Training.Time_Clock.src.main.java.org.example;
import java.time.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Main {
    public  static  void main(String[] args){

//...........................TO print the Date of.............
//        LocalDate now= LocalDate.now();
//        System.out.println("Today Date is : " + now);

//............................ Day of the Week.................
        DayOfWeek Day = DayOfWeek.MONDAY;

        System.out.println("Day is the : " + Day);
// .................... Month.................................
        Month month= Month.OCTOBER;
        System.out.println(" Month is : " + month);

//  ................... Print the Date .............................

//        LocalDate now=LocalDate.now();

//        int day=now.getDayOfMonth();
//        int year=now.getYear();
//        int Month=now.lengthOfMonth();
//        System.out.println(day);
//        System.out.println(year);
//        System.out.println(Month);

//.........................................Clock...............................
//        LocalTime time = LocalTime.now();
//
//
//
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss");
//
//        System.out.println("Current Time: " + time.format(format));





    }
}