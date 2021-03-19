package operations;

public class Employee {

	private static int counter;
	private int id;
	private String name;
	private int age;
	private int salary;

	public Employee() {
	}

	public Employee(String name, int age, int salary) {
		this.id = ++Employee.counter;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

}
