package Java8stremsprograms;


import java.util.*;

class Employee3 {
    private String name;
    private int age;
    private double salary;
    
	public Employee3(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

  
}

public class AddingSalIncrementPersentageToEmp {
    public static void main(String[] args) {
    	Employee3 e1 = new Employee3("John", 20, 50000);
    	Employee3 e2 = new Employee3("Alice", 25, 60000);
    	Employee3 e3 = new Employee3("Bob", 22, 45000);
    	Employee3 e4 = new Employee3("Carol", 23, 55000);
    	Employee3 e5 = new Employee3("David", 40, 70000);
    	Employee3 e6 = new Employee3("Emma", 32, 75000);

        List<Employee3> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

        employees.stream()
                .filter(emp -> emp.getAge() > 25)
                .forEach(emp -> {
        double increasedSalary = emp.getSalary() * 1.10; 
                    emp.setSalary(increasedSalary);
                });

        // Print the updated salaries
        System.out.println("Updated salaries:");
        employees.forEach(emp -> System.out.println(emp.getName() + ": " + emp.getSalary()));
    }
}
