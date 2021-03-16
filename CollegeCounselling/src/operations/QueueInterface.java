package operations;

public class QueueInterface {

	public int size;
	public int front, rear;
	public Object[] queue;

	public QueueInterface(int size) {
		this.front = -1;
		this.rear = -1;
		this.size = size;
		queue = new Object[size];
	}

	public void enqueue(Object obj) {
		// If queue is full
		if ((front == 0 && rear == size - 1) || (rear == (front - 1))) {
			System.out.print("Queue is Full !");
		}

		// Empty queue
		else if (front == -1) {
			front = 0;
			rear = 0;
			queue[rear] = obj;
		} else if (rear == size - 1 && front != 0) {
			rear = 0;
			queue[rear] = obj;
		} else {
			rear = (rear + 1);
			queue[rear] = obj;
		}
	}

	public Object dequeue() {
		Object obj = null;
		if (front == -1) {
			System.out.print("Queue is Empty");
		}
		if (front == rear) {
			obj = queue[front];
			front = -1;
			rear = -1;
		} else if (front == size - 1) {
			obj = queue[front];
			front = 0;
		} else {
			obj = queue[front];
			front = front + 1;
		}
		return obj;
	}

//	public void display() {
//		// Queue empty
//		if (front == -1) {
//			System.out.print("Queue is Empty");
//			return;
//		}
//
//		System.out.println("Your queue: ");
//
//		// if rear < size
//		if (rear >= front) {
//			for (int i = front; i <= rear; i++) {
//				System.out.print(queue[i].name + "\t" + queue[i].allocation);
//				System.out.print("\n");
//			}
//		}
//
//		// if rear < front
//		else {
//			// front to size
//			for (int i = front; i < size; i++) {
//				System.out.print(queue[i].name + "\t" + queue[i].allocation);
//				System.out.print("\n");
//			}
//
//			// 0 to rear
//			for (int i = 0; i <= rear; i++) {
//				System.out.print(queue[i].name + "\t" + queue[i].allocation);
//				System.out.print("\n");
//			}
//			System.out.println();
//		}
//
//	}
}
