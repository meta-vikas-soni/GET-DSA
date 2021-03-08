package operations;

class StackInterface {
	int size;
	int arr[];
	int top;

	StackInterface() {
		this.size = 100;
		this.arr = new int[size];
		this.top = -1;
	}

	public void push(int element) {
		if (top == size - 1) {
			System.out.println("Stack is full");

		} else {
			top++;
			arr[top] = element;
		}
	}

	public int pop() {
		if (!isEmpty()) {
			int element = top;
			top--;
			return arr[element];
		} else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	public int peek() {
		if (!this.isEmpty())
			return arr[top];
		else {
			System.out.println("Stack is Empty");
			return -1;
		}
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		int size = 0;
		for (int i = 0; i <= top; i++) {
			size++;
		}
		return size;
	}

}