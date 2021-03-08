package operations;

class StackInterfaceChar {
	int size;
	char arr[];
	int top;

	StackInterfaceChar() {
		this.size = 100;
		this.arr = new char[size];
		this.top = -1;
	}

	public void push(char element) {
		if (top == size - 1) {
			System.out.println("Stack is full");

		} else {
			top++;
			arr[top] = element;
		}
	}

	public char pop() {
		if (!isEmpty()) {
			int element = top;
			top--;
			return arr[element];
		} else {
			System.out.println("Stack is empty");
			return '0';
		}
	}

	public char peek() {
		if (!this.isEmpty())
			return arr[top];
		else {
			System.out.println("Stack is Empty");
			return '0';
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