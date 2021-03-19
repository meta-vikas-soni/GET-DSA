package operations;

import java.util.Scanner;

public class GenerateQueueMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Constructing queue
		System.out.println("Construct a queue:\n");
		System.out.println("Enter size of queue: ");
		PriorityQueueInterface queue = new PriorityQueueInterface(in.nextInt());
		boolean flag = true;
		try {
			while (flag) {
				int choice;
				System.out
						.println("\n1. Enqueue\n2. Dequeue \n3. Peek\n4. Display Queue\n5. Exit\n");
				choice = in.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter data: ");
					int data = in.nextInt();
					System.out.println("Enter priority of " + data);
					int priority = in.nextInt();
					queue.enqueue(data, priority);
					break;
				case 2:
					queue.dequeue();
					break;
				case 3:
					int index = queue.peek();
					System.out.println("Highest priority data: "
							+ queue.getDataByIndex(index));
					break;
				case 4:
					queue.displayQueue();
					break;
				case 5:
					flag = false;
					break;
				default:
					System.out.println("Invalid Option !");

				}
			}
		} catch (Exception e) {
			System.out.print("Invalid option!");
		}
		in.close();

	}

}
