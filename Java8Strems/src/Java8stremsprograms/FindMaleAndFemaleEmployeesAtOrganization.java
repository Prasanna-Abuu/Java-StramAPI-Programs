package Java8stremsprograms;

import java.util.Arrays;
import java.util.List;

public class FindMaleAndFemaleEmployeesAtOrganization {
	public static void main(String[] args) {
        Employees e1 = new Employees("John", "Male", 30);
        Employees e2 = new Employees("Alice", "Female", 25);
        Employees e3 = new Employees("Bob", "Male", 35);
        Employees e4 = new Employees("Carol", "Female", 28);
        Employees e5 = new Employees("David", "Male", 40);
        Employees e6 = new Employees("Emma", "Female", 32);

        List<Employees> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

        long maleCount = employees.stream()
                .filter(e -> e.getGender().equalsIgnoreCase("Male"))
                .count();

        long femaleCount = employees.stream()
                .filter(e -> e.getGender().equalsIgnoreCase("Female"))
                .count();

        System.out.println("Number of Male employees: " + maleCount);
        System.out.println("Number of Female employees: " + femaleCount);
    }
}
