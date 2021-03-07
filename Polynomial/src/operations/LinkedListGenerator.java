package operations;

import java.util.ArrayList;

//Java program to implement 
//a Singly Linked List 
public class LinkedListGenerator {

	public LinkedListGenerator() {

	}

	Node head, tail; // head and tail of list
	int len;

	public static class Node {
		Node depth;
		int coeff;
		String var;
		int expo;
		Node next;

		Node(int coeff, String var, int expo) {
			this.depth = null;
			this.coeff = coeff;
			this.var = var;
			this.expo = expo;
			this.next = null;
		}
	}

	// Method to insert a term node at end
	public void insertTermNode(LinkedListGenerator list,
			ArrayList<Node> nodeArray) {
		// Create a new node with given data
		Node new_node = nodeArray.get(0);
		// Adding first variable node
		if (list.head == null) {
			list.head = new_node;
			list.tail = new_node;
		} else {
			list.tail.next = new_node;
			list.tail = new_node;
		}
		// adding rest term
		if (nodeArray.size() > 1) {
			insertDepthNode(nodeArray);
		}
	}

	// Method to insert a depth node at end
	public void insertDepthNode(ArrayList<Node> nodeArray) {
		for (int i = 1; i < nodeArray.size(); i++) {
			Node temp_node = nodeArray.get(0);
			while (temp_node.depth != null) {
				temp_node = temp_node.depth;
			}
			temp_node.depth = nodeArray.get(i);
		}
	}

	public static String superscript(String str) {
		str = str.replaceAll("0", "");
		str = str.replaceAll("1", "");
		str = str.replaceAll("2", "^2");
		str = str.replaceAll("3", "^3");
		str = str.replaceAll("4", "^4");
		str = str.replaceAll("5", "^5");
		str = str.replaceAll("6", "^6");
		str = str.replaceAll("7", "^7");
		str = str.replaceAll("8", "^8");
		str = str.replaceAll("9", "^9");
		return str;
	}

	public void getLen(LinkedListGenerator list) {
		Node currNode = list.head;
		// Traverse through the LinkedList
		len = 0;
		while (currNode != null) {
			len++;
			currNode = currNode.next;
		}

	}

	// Method to print the LinkedList.
	public void displayPolynomial(LinkedListGenerator list) {
		Node currNode = list.head;
		Node holdNode = currNode;
		System.out.print("\nPolynomial:\n");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			String sign = "";
			sign = currNode.coeff < 0 ? " " : " +";

			if (currNode == head) {
				if (currNode.coeff == 0 || currNode.expo == 0) {
				} else {
					System.out.print(currNode.coeff + currNode.var
							+ superscript(Integer.toString(currNode.expo)));
				}
			} else {
				if (currNode.coeff == 0) {

				} else if (currNode.expo == 0) {
					System.out.print(sign + currNode.coeff);
				} else {
					System.out.print(sign + currNode.coeff + currNode.var
							+ superscript(Integer.toString(currNode.expo)));
				}
			}

			holdNode = currNode;
			while (currNode.depth != null) {
				currNode = currNode.depth;

				sign = currNode.coeff < 0 ? "" : "+";

				if (currNode.coeff == 0 || currNode.expo == 0) {
				} else {
					System.out.print(currNode.var
							+ superscript(Integer.toString(currNode.expo)));
				}
			}
			currNode = holdNode;
			currNode = currNode.next;
		}
	}

	public int getDegree(LinkedListGenerator list) {
		int degree = 0, temp = 0;
		Node currNode = list.head;
		Node holdNode = currNode;
		System.out.print("\n");

		// Traverse through the LinkedList
		while (currNode != null) {
			temp += currNode.expo;

			holdNode = currNode;
			while (currNode.depth != null) {
				currNode = currNode.depth;
				temp += currNode.expo;
			}
			if (temp > degree) {
				degree = temp;
			}
			temp = 0;
			currNode = holdNode;
			currNode = currNode.next;
		}

		return degree;
	}
}
