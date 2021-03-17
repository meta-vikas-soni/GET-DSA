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
		if (front == -1) {
			System.out.print("Queue is Empty");
			return;
		}
		// one element
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			front = front + 1;
		}

		int index = peek();
		// find the position of the element with highest priority and left shift
		// in array
		for (int i = index; i < rear; i++) {
			queue[i] = queue[i + 1];
		}

		// Decrease the size of the
		// priority queue by one
		rear--;
		System.out.print("Removed " + queue[index].data + "\n");
	}

	// returns index of highest priority
	public int peek() {
		int highestPriority = -999;
		int index = -1;

		// Check for the element with
		// highest priority
		for (int i = 0; i <= rear; i++) {

			// If priority is same choose the element with the highest value
			if (highestPriority == queue[i].priority && index > -1
					&& queue[index].data > queue[i].data) {
				highestPriority = queue[i].priority;
				index = i;
			} else if (highestPriority < queue[i].priority) {
				highestPriority = queue[i].priority;
				index = i;
			}
		}

		return index;
	}

	public int getDataByIndex(int index) {
		int data = -1;
		if (index >= 0 && index <= rear) {
			data = queue[index].data;
		}

		return data;
	}

}
