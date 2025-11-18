package Java8stremsprograms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindSecondHigthsSalByEmployee {
public static void main(String[] args) {
    	
    	Employee e1 = new Employee("John", "IT", 50000);
    	Employee e2 = new Employee("Alice", "IT", 60000);
    	Employee e3 = new Employee("Bob", "HR", 45000);
    	Employee e4 =  new Employee("Carol", "HR", 55000);
    	Employee e5 =  new Employee("David", "Finance", 80000);
        Employee e6 = new Employee("Emma", "Finance", 75000);
    	
        List<Employee> employees = new ArrayList<>();        
        
        employees.add(e1);   
        employees.add(e2);
        employees.add(e3);   
        employees.add(e4);
        employees.add(e5);   
        employees.add(e6);

        Optional<Double> secondHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .skip(1) // Skip the first highest salary
                .findFirst(); // Get the first element after skipping

        if (secondHighestSalary.isPresent()) {
            System.out.println("Second Highest Salary: " + secondHighestSalary.get());
        } else {
            System.out.println("No second highest salary found.");
        }
    }
}
