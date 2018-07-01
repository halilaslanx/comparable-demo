
public class Employee implements Comparable<Employee> {
	private String firstName;
	private String lastName;
	private int id;
	private int age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int id) {
		this.id = age;
	}

	public Employee(String firstName, String lastName, int age, int id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.id = id;
	}

	@Override
	public int compareTo(Employee other) {
		// Name sort
	    int last = this.lastName.compareTo(other.lastName);
	     //Sorting by first name if last name is same d
	    return last == 0 ? this.firstName.compareTo(other.firstName) : last;		
	    
	    // ID sort
		// return this.getId() - other.getId();
	}

}
