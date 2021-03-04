package operations;

import java.util.Scanner;

public class RotateList {

	LinkedListGenerator list = new LinkedListGenerator();
	int size;
	Scanner in = new Scanner(System.in);

	// Initializing list
	public void initList() {
		System.out.println("Enter number of elements in list:");
		size = in.nextInt();
		System.out.println("Enter " + size + " elements:");
		for (int i = 0; i < size; i++) {
			list.insertNodeEnd(list, in.nextInt());
		}

	}

	// Displaying list
	private void displayList() {
		list.printList(list);
	}

	/*
	 * Creating Sublist
	 * 
	 * @param listMain => Number of rotations to be performed
	 * 
	 * @param left => Starting position of sublist from listMain
	 * 
	 * @param right => Ending position of sublist from listMain
	 */
	private void subList(LinkedListGenerator listMain, int left, int right)
			throws Exception {
		listMain.getLen(listMain);
		list.getLen(list);
		if (left < 1 || left > listMain.len || left > listMain.len || right < 1
				|| right > listMain.len || right > listMain.len) {

			throw new Exception(
					"Left and Right positions are not in range of main list !");

		}
		for (int i = left; i <= right; i++) {
			int data = listMain.get(listMain, i);
			list.insertNodeEnd(list, data);
		}
	}

	/*
	 * Rotating Sublist
	 * 
	 * @param rotations => Number of rotations to be performed
	 */
	private void rotateList(int rotations) {
		int temp;
		for (int i = 0; i < rotations; i++) {
			temp = list.removeNodeEnd(list);
			list.insertNodeStart(list, temp);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		RotateList list1 = new RotateList();
		list1.initList();
		list1.displayList();

		// creating sublist
		RotateList list2 = new RotateList();
		int left;
		int right;
		System.out.println("\n\nCreating Sublist: ");
		System.out.println("Enter left position of sublist list: ");
		left = in.nextInt();
		System.out.println("Enter right position of sublist list: ");
		right = in.nextInt();
		try {
			list2.subList(list1.list, left, right);
			list2.displayList();

			// rotating sublist
			int rotations = 0;
			System.out.println("\n\nRotating Sublist: ");
			System.out.println("Enter number of rotations: ");
			rotations = in.nextInt();
			list2.rotateList(rotations);
			list2.displayList();
		} catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}
		in.close();

		// LinkedListGenerator listt = new LinkedListGenerator();
		//
		//
		// // Insert the values
		// listt.insertNode(listt, 1);

	}

}
