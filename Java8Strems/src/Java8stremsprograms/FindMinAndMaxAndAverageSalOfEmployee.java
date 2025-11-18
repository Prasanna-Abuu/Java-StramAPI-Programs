package Java8stremsprograms;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class FindMinAndMaxAndAverageSalOfEmployee {
    public static void main(String[] args) {
    	
    	
        Employee e1 = new Employee("John", "IT", 50000);
        Employee e2 = new Employee("Alice", "IT", 60000);
        Employee e3 = new Employee("Bob", "HR", 45000);
        Employee e4 = new Employee("Carol", "HR", 55000);
        Employee e5 = new Employee("David", "Finance", 80000);
        Employee e6 = new Employee("Emma", "Finance", 75000);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);

        // Find minimum salary
        OptionalDouble minSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .min();
        if (minSalary.isPresent()) {
            System.out.println("Minimum Salary: " + minSalary.getAsDouble());
        } else {
            System.out.println("No employees found.");
        }

        // Find maximum salary
        OptionalDouble maxSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max();
        if (maxSalary.isPresent()) {
            System.out.println("Maximum Salary: " + maxSalary.getAsDouble());
        } else {
            System.out.println("No employees found.");
        }

        // Find average salary
        OptionalDouble avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average();
        if (avgSalary.isPresent()) {
            System.out.println("Average Salary: " + avgSalary.getAsDouble());
        } else {
            System.out.println("No employees found.");
        }
    }
}
