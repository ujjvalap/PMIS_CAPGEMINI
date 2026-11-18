
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeAPI {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        Instant utcMoment = Instant.now();

        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Date/time: " + dateTime);
        System.out.println("India: " + indiaTime);
        System.out.println("Instant: " + utcMoment);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Formatted: " + date.format(formatter));
        System.out.println("After 7 days: " + date.plusDays(7));

        Period period = Period.between(date, date.plusMonths(2));
        Duration duration = Duration.between(time, time.plusHours(3));
        System.out.println("Period: " + period);
        System.out.println("Duration: " + duration);
    }
}
