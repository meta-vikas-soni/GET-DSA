package operations;

import java.util.ArrayList;
import java.util.Scanner;

import operations.LinkedListGenerator.Node;

public class PolynomialList {

	LinkedListGenerator list = new LinkedListGenerator();
	int varTypes;
	Scanner in = new Scanner(System.in);
	String[] vars = { "X", "Y", "Z" };

	// Initializing list
	public void addPolyTerm() {
		int coeff, expo;
		list.getLen(list);
		ArrayList<Node> nodeArray = new ArrayList<Node>();
		System.out.println("Polynomial Term " + (list.len + 1) + ":");
		System.out.println("Enter coefficient of term " + (list.len + 1) + ":");
		coeff = in.nextInt();
		for (int i = 0; i < varTypes; i++) {
			System.out.println("Enter exponent of variable " + vars[i] + ":");
			expo = in.nextInt();
			if (i >= 1) {
				coeff = 1;
			}
			if (coeff != 0) {
				Node new_node = new Node(coeff, vars[i], expo);
				new_node.next = null;
				new_node.depth = null;
				nodeArray.add(new_node);
			}
		}
		list.insertTermNode(list, nodeArray);

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		PolynomialList p1 = new PolynomialList();
		boolean flag = true;
		// Constructing polynomial
		System.out.println("Construct a polynomial:\n");
		System.out.println("Enter total types of variables: ");
		p1.varTypes = in.nextInt();
		while (flag) {
			int choice;
			System.out
					.println("\n1. Add term\n2. Display Polynomial \n3. Evaluate highest degree\n4. Exit\n");
			choice = in.nextInt();
			switch (choice) {
			case 1:
				p1.addPolyTerm();
				break;
			case 2:
				p1.list.displayPolynomial(p1.list);
				break;
			case 3:
				int degree = p1.list.getDegree(p1.list);
				System.out.println("Highest Degree: " + degree);
				break;
			case 4:
				flag = false;
				break;
			default:
				System.out.println("Invalid Option !");

			}
		}
		in.close();
	}

}
