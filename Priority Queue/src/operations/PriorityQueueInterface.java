package operations;

public class PriorityQueueInterface {

	public int size;
	public int front, rear;
	private QueueItem[] queue;

	public PriorityQueueInterface() {
	}

	public PriorityQueueInterface(int size) {
		this.front = -1;
		this.rear = -1;
		this.size = size;
		queue = new QueueItem[size];
	}

	public void enqueue(int data, int priority) {
		QueueItem item = new QueueItem(data, priority);
		// If queue is full
		if ((front == 0 && rear == size - 1)) {
			System.out.print("Queue is Full !");
		}
		// Empty queue
		else if (front == -1) {
			front = 0;
			rear = 0;
			queue[rear] = item;
		} else {
			rear = (rear + 1);
			queue[rear] = item;
		}
	}

	public void dequeue() {
		if (front == -1 || rear == -1) {
			System.out.print("Queue is Empty !");
			return;
		}
		// one element
		if (front == rear) {
			System.out.print("Removed " + queue[front].data + "\n");
			front = -1;
			rear = -1;
		} else {
			int index = peek();
			System.out.print("Removed " + queue[index].data + "\n");
			// find the position of the element with highest priority and left
			// shift in array
			for (int i = index; i < rear; i++) {
				queue[i] = queue[i + 1];
			}

			// Decrease the size of the
			// priority queue by one
			rear--;
		}
	}

	// returns index of highest priority
	public int peek() {
		int highestPriority = -999;
		int index = -1;

		// Check for the element with highest priority
		for (int i = 0; i <= rear; i++) {
			if (highestPriority < queue[i].priority) {
				highestPriority = queue[i].priority;
				index = i;
			}
		}

		return index;
	}

	// display queue
	public void displayQueue() {
		if (front == -1 || rear == -1) {
			System.out.println("\nQueue is empty !");
		} else {
			System.out.println("Data\tPriority");
			for (int i = front; i <= rear; i++) {
				System.out.print(queue[i].data + "\t" + queue[i].priority
						+ "\n");
			}
		}
	}

	public int getDataByIndex(int index) {
		int data = -1;
		if (index >= 0 && index <= rear) {
			data = queue[index].data;
		}

		return data;
	}

}
