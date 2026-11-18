import java.util.*;
import java.util.stream.*;

public class Collectors {
    static class Employee {
        private final String name;
        private final String department;
        private final int salary;

        Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        String getName() { return name; }
        String getDepartment() { return department; }
        int getSalary() { return salary; }
        public String toString() { return name + " - " + department + " - " + salary; }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Aman", "IT", 60000),
                new Employee("Rahul", "HR", 45000),
                new Employee("Neha", "IT", 75000),
                new Employee("Priya", "HR", 52000)
        );

        Map<String, List<Employee>> byDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Grouping: " + byDepartment);

        Map<Boolean, List<Employee>> bySalary = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() >= 50000));
        System.out.println("Partitioning: " + bySalary);

        String names = employees.stream().map(Employee::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Joining: " + names);

        int totalSalary = employees.stream()
                .collect(Collectors.summingInt(Employee::getSalary));
        System.out.println("Total salary: " + totalSalary);

        Map<String, Integer> salaryByName = employees.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        System.out.println("To map: " + salaryByName);
    }
}
