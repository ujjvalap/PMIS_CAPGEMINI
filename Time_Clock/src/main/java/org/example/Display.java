package CG_Java_Training.Time_Clock.src.main.java.org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Display {

    public static void displayMonth(LocalDate date) {
        System.out.println("Month: " + date.getMonth());
    }

    public static void displayYear(LocalDate date) {
        System.out.println("Year: " + date.getYear());
    }

    public static void displayDay(LocalDate date) {
        System.out.println("Day of Week: " + date.getDayOfWeek());
    }

    public static void checkLeapYear(LocalDate date) {
        if (date.isLeapYear()) {
            System.out.println("It is a Leap Year.");
        } else {
            System.out.println("It is not a Leap Year.");
        }
    }

    public static void lookBackMonths(LocalDate date, Scanner sc) {
        System.out.print("Enter months to look back: ");
        int months = sc.nextInt();

        LocalDate newDate = date.minusMonths(months);

        System.out.println("New Date: " + newDate);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date (yyyy-MM-dd): ");
        String input = sc.nextLine();

        LocalDate date = LocalDate.parse(input);

        int choice;

        do {
            System.out.println("\n--- Date Explorer Menu ---");
            System.out.println("1. Display Month");
            System.out.println("2. Display Year");
            System.out.println("3. Display Day of Week");
            System.out.println("4. Check Leap Year");
            System.out.println("5. Look Back Months");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayMonth(date);
                    break;

                case 2:
                    displayYear(date);
                    break;

                case 3:
                    displayDay(date);
                    break;

                case 4:
                    checkLeapYear(date);
                    break;

                case 5:
                    lookBackMonths(date, sc);
                    break;

                case 6:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
