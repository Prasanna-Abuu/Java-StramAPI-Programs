package Java8stremsprograms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindTheNamesOfEmployeeFromListBasedOnDepartment {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", "IT", 50000);
        Employee e2 = new Employee("Alice", "IT", 60000);
        Employee e3 = new Employee("Bob", "HR", 45000);
        Employee e4 = new Employee("Carol", "HR", 55000);
        Employee e5 = new Employee("David", "Finance", 70000);
        Employee e6 = new Employee("Emma", "Finance", 75000);
        
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);

        String departmentToFind = "Finance";

        List<String> namesInDepartment = employees.stream()
                .filter(e -> e.getDepartment().equals(departmentToFind))
                .map(Employee::getName)
                .collect(Collectors.toList());

        namesInDepartment.forEach(System.out::println);
        
    }
}
