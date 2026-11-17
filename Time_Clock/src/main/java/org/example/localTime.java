package CG_Java_Training.Time_Clock.src.main.java.org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;


public class localTime {

    public static  void main(String[] args)
    {
//        LocalTime now = LocalTime.now();
//        System.out.println(now);
//
//        LocalDateTime time=LocalDateTime.parse("2026-10-26T13:48");
//        System.out.println(time);
//
//        ZonedDateTime now= ZonedDateTime.now();
//
//        System.out.println(now);

        Set<String> availableZones = ZoneId.getAvailableZoneIds();

        ArrayList<String> zones = new ArrayList<>(availableZones);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter zone number  ");

        int id = sc.nextInt();

        if (id >= 0 && id < zones.size()) {
            System.out.println(" Time Zone: " + zones.get(id));
        } else {
            System.out.println("Invalid zone number");
        }


    }
}
