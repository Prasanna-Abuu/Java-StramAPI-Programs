package Java8stremsprograms;
import java.util.*;
import java.util.stream.Collectors;

class Employee2 {
    private String name;
    private String city;
    private double salary;

    public Employee2(String name, String city, double salary) {
        this.name = name;
        this.city = city;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public double getSalary() {
        return salary;
    }
}

public class GroupByListOfEmployeesByCity {
    public static void main(String[] args) {
    	
        Employee2 e1 = new Employee2("John", "New York", 50000);
        Employee2 e2 = new Employee2("Alice", "Los Angeles", 60000);
        Employee2 e3 = new Employee2("Bob", "New York", 45000);
        Employee2 e4 = new Employee2("Carol", "Chicago", 55000);
        Employee2 e5 = new Employee2("David", "Los Angeles", 70000);
        Employee2 e6 = new Employee2("Emma", "Chicago", 75000);

        List<Employee2> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

        Map<String, List<Employee2>> employeesByCity = employees.stream()
                .collect(Collectors.groupingBy(Employee2::getCity));
     
        employeesByCity.forEach((city, empList) -> {
            System.out.println("City: " + city);
            empList.forEach(emp -> System.out.println("Employee: " + emp.getName() + ", Salary: " + emp.getSalary()));
            System.out.println("----------------------");
        });
    }
}
