package operations;

public class Student {

	public String name;
	public String[] preference = new String[5];
	public String allocation;

	public void createStudent(String name, String pref, String allocation) {
		this.name = name;
		this.preference = pref.split(",");
		this.allocation = allocation;
	}

	public void allocateCourse(String courseName) {
		this.allocation = courseName;
	}

}
