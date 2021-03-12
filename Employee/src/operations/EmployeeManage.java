package operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeManage {

	public static ArrayList<Employee> empList = new ArrayList<Employee>();

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		boolean exit = false;
		String choice;
		System.out.println("Employee Management");
		while (!exit) {
			System.out
					.println("\n1. Add Employee\n2. Natural Sort\n3. Sort by Name\n4. Display employees\n5. Exit");
			choice = in.nextLine();
			switch (choice) {
			case "1":
				System.out.println("Enter employee id:");
				int id = in.nextInt();
				in.nextLine();
				boolean empIdExist = false;
				for (int i = 0; i < empList.size(); i++) {
					if (empList.get(i).empId == id) {
						empIdExist = true;
						break;
					}
				}
				if (!empIdExist) {
					System.out.println("Enter employee name:");
					String name = in.nextLine();
					System.out.println("Enter employee address:");
					String addr = in.nextLine();
					empList.add(new Employee(id, name, addr));

				} else {
					System.out.println("Employee id already exists !");
					break;
				}

				break;
			case "2":
				Collections.sort(empList, new SortNatural());
				System.out.println("\nSorted Naturally !");
				break;
			case "3":
				Collections.sort(empList, new SortByName());
				System.out.println("\nSorted by Name !");
				break;
			case "4":
				System.out.println("------Employee List------");
				for (int i = 0; i < empList.size(); i++) {
					System.out.println("\nEmpId: " + empList.get(i).empId);
					System.out.println("EmpName: " + empList.get(i).empName);
					System.out.println("EmpAddress: " + empList.get(i).empAddr);
				}
				break;
			case "5":
				exit = true;
				break;
			default:
				System.out.println("Wrong choice !");
			}

		}
		in.close();

	}

}
