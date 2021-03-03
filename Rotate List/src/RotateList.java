import java.util.LinkedList;
import java.util.Scanner;

public class RotateList {

	LinkedList<Integer> list = new LinkedList<>();
	int size;
	Scanner in = new Scanner(System.in);

	// Initializing list
	public void initList() {
		System.out.println("Enter number of elements in list:");
		size = in.nextInt();
		System.out.println("Enter " + size + " elements:");
		for (int i = 0; i < size; i++) {
			list.add(in.nextInt());
		}

	}

	// Displaying list
	private void displayList() {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
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
	private void subList(LinkedList<Integer> listMain, int left, int right)
			throws Exception {
		if (left < 1 || left > listMain.size() || left > listMain.size()
				|| right < 1 || right > listMain.size()
				|| right > listMain.size()) {

			throw new Exception(
					"Left and Right positions are not in range of main list !");

		}
		for (int i = left - 1; i < right; i++) {
			list.add(listMain.get(i));
		}
		size = list.size();
	}

	/*
	 * Rotating Sublist
	 * 
	 * @param rotations => Number of rotations to be performed
	 */
	private void rotateList(int rotations) {
		int temp;
		for (int i = 0; i < rotations; i++) {
			temp = list.remove();
			list.add(temp);
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
	}

}
