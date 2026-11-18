import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamPractice {
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
        public String toString() { return name + " (" + department + ", " + salary + ")"; }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Aman", "IT", 60000),
                new Employee("Rahul", "HR", 45000),
                new Employee("Neha", "IT", 85000),
                new Employee("Priya", "HR", 52000),
                new Employee("Karan", "Sales", 70000)
        );

        System.out.println("Salary > 50000:");
        employees.stream().filter(e -> e.getSalary() > 50000)
                .forEach(System.out::println);

        System.out.println("Sorted by salary descending:");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .forEach(System.out::println);

        System.out.println("Highest paid employee:");
        employees.stream().max(Comparator.comparingInt(Employee::getSalary))
                .ifPresent(System.out::println);

        System.out.println("Employees by department:");
        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)));

        System.out.println("Average salary: " + employees.stream()
                .mapToInt(Employee::getSalary).average().getAsDouble());
    }
}
