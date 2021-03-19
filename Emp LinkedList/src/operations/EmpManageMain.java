package operations;

import java.util.Scanner;

public class EmpManageMain {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		LinkedListInterface empList = new LinkedListInterface();
		boolean exit = false;
		String choice;
		System.out.println("Employee Management");
		while (!exit) {
			System.out
					.println("\n1. Add Employee\n2. Insertion Sort\n3. Quick Sort\n4. Display employees\n5. Exit");
			choice = in.nextLine();
			switch (choice) {
			case "1":

				System.out.println("Enter employee name:");
				String name = in.nextLine();
				System.out.println("Enter employee age:");
				int age = in.nextInt();
				System.out.println("Enter employee salary:");
				int salary = in.nextInt();
				Employee emp = new Employee(name, age, salary);
				empList.insertNodeEnd(empList, emp);
				in.nextLine();
				break;
			case "2":
				empList.head=empList.insertionSortList(empList.head);
				break;
			case "3":
				// Collections.sort(empList, new SortByName());
				break;
			case "4":
				empList.printList(empList);
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
