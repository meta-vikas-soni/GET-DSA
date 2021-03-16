package operations;

import java.util.Scanner;

public class ImplementQueue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Constructing queue
		System.out.println("Construct a queue:\n");
		System.out.println("Enter size of queue: ");
		Queue queue = new Queue(in.nextInt());
		boolean flag = true;
		try{
		while (flag) {
			int choice;
			System.out
					.println("\n1. Enqueue\n2. Dequeue \n3. Display Queue\n4. Exit\n");
			choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter data: ");
				int data = in.nextInt();
				queue.enqueue(data);
				break;
			case 2:
				queue.dequeue();
				break;
			case 3:
				queue.display();
				break;
			case 4:
				flag = false;
				break;
			default:
				System.out.println("Invalid Option !");

			}
		}}
		catch(Exception e){
			System.out.print("Invalid option!");
		}
		in.close();

	}

}
