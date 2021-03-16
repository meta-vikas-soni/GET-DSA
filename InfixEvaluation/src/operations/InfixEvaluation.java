package operations;

import java.util.*;

public class InfixEvaluation {

	public static int precedence(char optor) {
		if (optor == '+') {
			return 1;
		} else if (optor == '-') {
			return 1;
		} else if (optor == '*') {
			return 2;
		} else {
			return 2;
		}
	}

	public static int operation(int v1, int v2, char optor) {
		if (optor == '+') {
			return v1 + v2;
		} else if (optor == '-') {
			return v1 - v2;
		} else if (optor == '*') {
			return v1 * v2;
		} else {
			return v1 / v2;
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter infix notation: ");
		String exp = in.nextLine();

		// Stack<Character> operator = new Stack<>();
		// Stack<Integer> operand = new Stack<>();

		StackInterface operator = new StackInterface();
		StackInterface operand = new StackInterface();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch == '(') {
				operator.push(ch);
			} else if (Character.isDigit(ch)) {
				String val = "";
				while (i < exp.length() && Character.isDigit(exp.charAt(i))) {
					val = val + exp.charAt(i++);
				}
				operand.push(Integer.parseInt(val));
				i--;
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (operator.size() > 0 && (char) operator.peek() != '('
						&& precedence(ch) <= precedence((char) operator.peek())) {
					int val2 = (int) operand.pop();
					int val1 = (int) operand.pop();
					char op = (char) operator.pop();

					int opval = operation(val1, val2, op);
					operand.push(opval);
				}

				operator.push(ch);
			} else if (ch == ')') {
				while (operator.size() > 0 && (char) operator.peek() != '(') {
					int val2 = (int) operand.pop();
					int val1 = (int) operand.pop();
					char op = (char) operator.pop();

					int opval = operation(val1, val2, op);
					operand.push(opval);
				}

				if (operator.size() > 0) {
					operator.pop();
				}
			}
		}
		while (operator.size() > 0) {
			char optor = (char) operator.pop();
			int v2 = (int) operand.pop();
			int v1 = (int) operand.pop();

			int opv = operation(v1, v2, optor);
			operand.push(opv);
		}
		int val = (int) operand.pop();
		System.out.println("\nOutput: " + val);

		in.close();

	}
}