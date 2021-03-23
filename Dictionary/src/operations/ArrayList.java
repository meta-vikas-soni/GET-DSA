package operations;

import java.util.EmptyStackException;

public class ArrayList<T> implements List<T> {

	public Node<T> head;

	/**
	 * Initialize a new node for linked list
	 * 
	 * @since 04-04-2021
	 * @author Hitesh Pareek
	 *
	 */

	/**
	 * Adds a node at the end of linked list
	 * 
	 * @param data
	 */
	@Override
	public boolean add(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		return true;
	}

	/**
	 * Finds the size of given Linked List
	 * 
	 * @param head
	 * @return size of list
	 */
	public int size(Node<T> head) {
		Node<T> temp = this.head;
		int countNode = 0;
		if (head == null) {
			return 0;
		}
		while (temp != null) {
			countNode++;
			temp = temp.next;
		}
		return countNode;
	}

	/**
	 * Prints the Linked List
	 */
	public void printNode() {
		if (head == null) {
			System.out.println("List is empty");
		} else {
			Node<T> temp = head;
			while (temp != null) {
				System.out.print(temp.data + "-->");
				temp = temp.next;
			}
		}
	}

	/**
	 * Removed value from the array list
	 * 
	 * @return value which is removed
	 */
	@Override
	public T remove() {
		if (head == null) {
			throw new EmptyStackException();
		}
		Node<T> temp = head;
		while (temp.next != null && temp.next.next != null) {
			temp = temp.next;
		}
		if(temp.next!=null) {
			T data=temp.next.data;
			temp.next=null;
			return data;
		}
		if (temp == head) {
			T data = temp.data;
			head = null;
			return data;
		}
		
		else {
			T data = temp.next.data;
			temp.next = null;
			return data;
		}
	}

	@Override
	public int size() {
		int size = 0;
		if (head == null) {
			return 0;
		} else {
			Node<T> temp = head;
			while (temp != null) {
				size++;
				temp = temp.next;
			}
			return size;
		}
	}

	public Node<T> get(Node<T> head,int index) {
		if (head==null) {
			throw new NullPointerException();
		} else {
			Node<T> temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			return temp;
		}

	}
}