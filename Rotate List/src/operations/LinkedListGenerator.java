package operations;

//Java program to implement 
//a Singly Linked List 
public class LinkedListGenerator {

	public LinkedListGenerator() {

	}

	Node head, tail; // head and tail of list
	int len;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Method to insert a new node at begin
	public void insertNodeStart(LinkedListGenerator list, int data) {
		// Create a new node with given data
		Node new_node = new Node(data);
		new_node.next = null;

		// If the Linked List is empty
		if (list.head == null) {
			list.head = new_node;
			list.tail = new_node;
		} else {
			new_node.next = list.head;
			list.head = new_node;
		}
	}

	// Method to insert a new node at end
	public void insertNodeEnd(LinkedListGenerator list, int data) {
		// Create a new node with given data
		Node new_node = new Node(data);
		new_node.next = null;

		// If the Linked List is empty
		if (list.head == null) {
			list.head = new_node;
			list.tail = new_node;
		} else {
			list.tail.next = new_node;
			list.tail = new_node;
		}
	}

	// Method to remove start node
	public int removeNodeStart(LinkedListGenerator list) {
		// Create a new node with given data
		Node temp_node;
		int temp = 0;

		// If the Linked List is empty
		if (list.head == null) {

		} else {
			temp_node = list.head;
			list.head = list.head.next;
			temp = temp_node.data;
		}

		return temp;
	}

	// Method to remove end node
	public int removeNodeEnd(LinkedListGenerator list) {
		// Create a new node with given data
		Node temp_node;
		int temp = 0;

		// If the Linked List is empty
		if (list.head == null) {

		} else {
			temp_node = list.head;
			while (temp_node.next != list.tail) {
				temp_node = temp_node.next;
			}
			temp = list.tail.data;
			list.tail = temp_node;
			list.tail.next = null;
		}

		return temp;
	}

	public void getLen(LinkedListGenerator list) {
		Node currNode = list.head;
		// Traverse through the LinkedList
		while (currNode != null) {
			len++;
			currNode = currNode.next;
		}
	}

	// Method to print the LinkedList.
	public void printList(LinkedListGenerator list) {
		Node currNode = list.head;

		System.out.print("\nLinkedList:\n");

		// Traverse through the LinkedList
		while (currNode != list.tail.next) {
			// Print the data at current node
			System.out.print(currNode.data + " ");

			// Go to next node
			currNode = currNode.next;
		}
	}

	public int get(LinkedListGenerator list, int pos) {
		Node currNode = list.head;
		int data = 0;
		int j = 0;

		while (j++ != pos) {
			data = currNode.data;
			currNode = currNode.next;
		}
		return data;
	}
}
