package Java8stremsprograms;

import java.util.Arrays;
import java.util.List;

class Employees {
    private String name;
    private String gender;
    private int age;

    public Employees(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}



public class AverageAgeOfMaleAndFemaleEmployee {
    public static void main(String[] args) {
        Employees e1 = new Employees("John", "Male", 30);
        Employees e2 = new Employees("Alice", "Female", 25);
        Employees e3 = new Employees("Bob", "Male", 35);
        Employees e4 = new Employees("Carol", "Female", 28);
        Employees e5 = new Employees("David", "Male", 40);
        Employees e6 = new Employees("Emma", "Female", 32);

        List<Employees> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

        // Calculate average age for male employees
        double avgAgeMale = employees.stream()
                .filter(e -> e.getGender().equals("Male"))
                .mapToInt(Employees::getAge)
                .average()
                .orElse(0.0); 

        // Calculate average age for female employees
        double avgAgeFemale = employees.stream()
                .filter(e -> e.getGender().equals("Female"))
                .mapToInt(Employees::getAge)
                .average()
                .orElse(0.0); 

        System.out.println("Average Age of Male Employees: " + avgAgeMale);
        System.out.println("Average Age of Female Employees: " + avgAgeFemale);
    }
}











