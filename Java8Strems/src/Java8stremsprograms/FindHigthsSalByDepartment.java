package Java8stremsprograms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class FindHigthsSalByDepartment {
    public static void main(String[] args) {
    	Employee e1 = new Employee("John", "IT", 50000);
    	Employee e2 = new Employee("Alice", "IT", 60000);
    	Employee e3 = new Employee("Bob", "HR", 45000);
    	Employee e4 =  new Employee("Carol", "HR", 55000);
    	Employee e5 =  new Employee("David", "Finance", 70000);
        Employee e6 = new Employee("Emma", "Finance", 75000);
    	
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);        
        
        
          Map<String, Optional<Employee>> highestSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        highestSalaryByDept.forEach((dept, employee) -> {
                     System.out.println("Department: " + dept + ", Highest Salary: " +
                     employee.get().getSalary());
        });
    }
}
