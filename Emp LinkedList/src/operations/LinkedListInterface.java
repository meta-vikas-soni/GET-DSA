package operations;

//Java program to implement 
//a Singly Linked List 
public class LinkedListInterface {

	public LinkedListInterface() {

	}

	Node head, tail; // head and tail of list
	int len;

	static class Node {
		Employee data;
		Node next;

		Node(Employee data) {
			this.data = data;
			this.next = null;
		}
	}

	// Method to insert a new node at end
	public void insertNodeEnd(LinkedListInterface list, Employee data) {
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

	// insertion Sort
	public Node insertionSortList(Node listHead) {
		System.out.println("Sorted using Insertion Sort !");
		// single node
		if (listHead.next == null) {
			return listHead;
		}

		Node sorted = null;
		Node temp = listHead;

		while (temp != null) {
			Node curr = temp;
			temp = temp.next;

			if (sorted == null
					|| (sorted.data.getSalary() <= curr.data.getSalary() && sorted.data
							.getAge() >= curr.data.getAge())) {
				curr.next = sorted;
				sorted = curr;
			} else {
				// traversing in sorted
				Node s = sorted;
				while (s != null) {
					if (s.next == null
							|| (s.next.data.getSalary() <= curr.data
									.getSalary() && sorted.data.getAge() >= curr.data
									.getAge())) {
						curr.next = s.next;
						s.next = curr;
						break;
					}
					s = s.next;
				}
			}
		}
		return sorted;

	}

	// Method to print the LinkedList.
	public void printList(LinkedListInterface list) {
		Node currNode = list.head;

		System.out.print("\n-----Employee List-----\n");

		// Traverse through the LinkedList
		System.out.println("\nId\tName\t\tAge\tSalary");
		while (currNode != null) {
			// Print the data at current node
			System.out.println(+currNode.data.getId() + "\t"
					+ currNode.data.getName() + "\t\t" + currNode.data.getAge()
					+ "\t" + currNode.data.getSalary());
			// Go to next node
			currNode = currNode.next;
		}
		System.out.print("\n");
	}

	public Node paritionLast(Node start, Node end) {
		if (start == end || start == null || end == null)
			return start;

		Node pivot_prev = start;
		Node curr = start;
		Employee pivot = end.data;

		// iterate till one before the end, no need to iterate till the end
		// because end is pivot
		while (start != end) {
			if (start.data.getSalary() > pivot.getSalary()
					|| (start.data.getSalary() >= pivot.getSalary() && start.data
							.getAge() <= pivot.getAge())) {
				// keep tracks of last modified item
				pivot_prev = curr;
				Employee temp = curr.data;
				curr.data = start.data;
				start.data = temp;
				curr = curr.next;
			}
			start = start.next;
		}

		// swap the position of curr i.e. next suitable index and pivot
		Employee temp = curr.data;
		curr.data = pivot;
		end.data = temp;

		// return one previous to current because current is now pointing to
		// pivot
		return pivot_prev;
	}

	public void quickSortList(Node start, Node end) {
		if (start == null || start == end || start == end.next)
			return;

		// split list and partition recurse
		Node pivot_prev = paritionLast(start, end);
		quickSortList(start, pivot_prev);

		// if pivot is picked and moved to the start,that means start and pivot
		// is same so pick from next of pivot
		if (pivot_prev != null && pivot_prev == start)
			quickSortList(pivot_prev.next, end);

		// if pivot is in between of the list, start from next of pivot, since
		// we have pivot_prev, so we move two nodes
		else if (pivot_prev != null && pivot_prev.next != null)
			quickSortList(pivot_prev.next.next, end);

	}

}
