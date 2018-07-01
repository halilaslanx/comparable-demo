import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
	static List<Employee> employees; 

	public static void main(String[] args) {
		employees = Utility.getEmployeeList(5);
		
		// ==========  COMPARATOR  =============
		
		System.out.println("\n -- Sorted List : Comparator (ID) --");
		// before JAVA 8		
		EmployeeComparator byID = new EmployeeComparator();
		Collections.sort(employees, byID);

		Utility.printEmployeeList(employees);

		// -----
		
		System.out.println("\n -- Sorted List : Comparator (Age, Lambda) --");
		Comparator<Employee> byAge = (Employee e1, Employee e2) -> e1.getAge() - e2.getAge();
		Collections.sort(employees, (Employee e1, Employee e2) -> e1.getAge() - e2.getAge());

		Utility.printEmployeeList(employees);

		// -----
		
		System.out.println("\n -- Sorted List : Comparator (Age, reversed) --");
		Collections.sort(employees, byAge.reversed());
		
		Utility.printEmployeeList(employees);
		
		// -----

		System.out.println("\n -- Sorted List : Comparator.comparing (Lastname) --");
		Comparator<Employee> byLastName = Comparator.comparing(Employee::getLastName);
		Collections.sort(employees, byLastName);
		//Collections.sort(employees, Comparator.comparing(Employee::getLastName));
		
		Utility.printEmployeeList(employees);
		
		// -----

		System.out.println("\n -- Sorted List : Comparator.comparing (Length of lastname) --");
		// to Specify another comparator for that sort key
		// by the length of the last name
		byLastName = Comparator.comparing(Employee::getLastName, (s1, s2) -> s1.length() - s2.length() );
		Collections.sort(employees, byLastName);
		//Collections.sort(employees, Comparator.comparing(Employee::getLastName));
		
		Utility.printEmployeeList(employees);

		// -----
		
		System.out.println("\n -- Sorted List : Comparator.thenCommparing (Lastname, then FirstName) --");
		Comparator<Employee> byLastThenFirst = byLastName.thenComparing(Employee::getFirstName); 
		
		// three levels of sorting
		// Comparator<Employee> byLastThenFirstThenId = byLastName.thenComparing(Employee::getFirstName).thenComparing(Employee::getId); 

		// lets make two people with the same lastname
		employees.get(0).setLastName(employees.get(2).getLastName());
		// lets make two people with the same fullname
		// employees.get(0).setFirstName(employees.get(2).getFirstName());		
		
		Collections.sort(employees, byLastThenFirst);
				
		Utility.printEmployeeList(employees);

		
		//// reversed(), reverseOrder()
		Collections.shuffle(employees);
		System.out.println("\n -- Shuffled list --");
		Utility.printEmployeeList(employees);
		
		System.out.println("\n -- Sorted - Natural Reverse Order --");
		Collections.sort(employees, Comparator.reverseOrder());
		Utility.printEmployeeList(employees);

		// what if I want to have this comparator as an object?
		Comparator<Employee> revOrdCompObj = Comparator.reverseOrder();
		Collections.sort(employees, revOrdCompObj);		
		
		
		//// Anonymous Classes
		
		System.out.println("\n -- Sorted List : Comparator (ID)/Anoymous Classes --");
		// before JAVA 8		
		Comparator<Employee> byIDac = new Comparator<Employee>() {
			public int compare(Employee o1, Employee o2) {
				return o1.getId() - o2.getId();
			}
		};
		
		Collections.sort(employees, byIDac);

		Utility.printEmployeeList(employees);		
		
	}
}
