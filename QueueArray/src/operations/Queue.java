package operations;

public class Queue {

	public int size;
	public int front, rear;
	private int[] queue;

	public Queue(int size) {
		this.front = -1;
		this.rear = -1;
		this.size = size;
		queue = new int[size];
	}

	public void enqueue(int data) {
		// If queue is full
		if ((front == 0 && rear == size - 1) || (rear == (front - 1))) {
			System.out.print("Queue is Full !");
		}

		// Empty queue
		else if (front == -1) {
			front = 0;
			rear = 0;
			queue[rear] = data;
		} else if (rear == size - 1 && front != 0) {
			rear = 0;
			queue[rear] = data;
		} else {
			rear = (rear + 1);
			queue[rear] = data;
		}
	}

	public void dequeue() {
		if (front == -1) {
			System.out.print("Queue is Empty");
			return;
		}
		System.out.print("Removed " + queue[front]);
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == size - 1) {
			front = 0;
		} else {
			front = front + 1;
		}
	}

	public void display() {
		// Queue empty
		if (front == -1) {
			System.out.print("Queue is Empty");
			return;
		}

		System.out.println("Your queue: ");

		// if rear < size
		if (rear >= front) {
			for (int i = front; i <= rear; i++) {
				System.out.print(queue[i]);
				System.out.print(" ");
			}
		}

		// if rear < front
		else {
			// front to size
			for (int i = front; i < size; i++) {
				System.out.print(queue[i]);
				System.out.print(" ");
			}

			// 0 to rear
			for (int i = 0; i <= rear; i++) {
				System.out.print(queue[i]);
				System.out.print(" ");
			}
			System.out.println();
		}

	}
}
