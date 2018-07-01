import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

public class Utility {
	public static void printEmployeeList(List<Employee> employees) {
		for (Employee e : employees) {
			System.out.println(e.getId() + "\t" + e.getLastName() + ", " + e.getFirstName() + " (" + e.getAge() + ")");
		}
	}

	public static List<Employee> getEmployeeList(int numberOfEmployees)
	{
		List<Employee> employees = new ArrayList<>();
		Faker faker = new Faker();

		for (int i = 0; i < 5; i++) {
			employees.add(new Employee(faker.name().firstName(), faker.name().lastName(),
					faker.number().numberBetween(20, 80), faker.number().numberBetween(1000, 1100)));
		}
		
		return employees;
	}
}
