import java.util.HashMap;
import java.util.Scanner;

public class UniqueChars {

	private static HashMap<String, Integer> cache = new HashMap<String, Integer>();

	private static int getUniqueChar(String str) {
		str = str.toLowerCase();
		int count = 0, i = 0, j = 0;
		if (cache.get(str) != null) {
			count = cache.get(str);
			System.out.println("Cached data !");
		} else {
			String s2 = str.toLowerCase();
			StringBuffer sb = new StringBuffer(s2);
			int len = sb.length();
			for (i = 0; i < len; i++) {
				count = 0;
				for (j = i + 1; j < len; j++) {
					if (sb.charAt(i) == sb.charAt(j)) {
						sb.deleteCharAt(j);
						count++;
						j--;
						len--;
					}
				}
				if (count > 0) {
					sb.deleteCharAt(i);
					i--;
					len--;
				}
			}
			if (sb.length() == 0) {
				count = -1;
			} else {
				count = sb.length();
			}
			cache.put(str, count);
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str;
		boolean exit = false;
		String choice;
		System.out.println("Get unique character from string -");
		while (!exit) {
			System.out.println("\n1. Input new string\n2. Exit");
			choice = in.nextLine();
			switch (choice) {
			case "1":
				System.out.println("Enter string:");
				str = in.nextLine();
				int count = getUniqueChar(str);
				System.out.println("\nUnique characters in \"" + str
						+ "\" are: " + count);
				break;
			case "2":
				exit = true;
				break;
			default:
				System.out.println("Wrong choice !");
			}

		}
		in.close();
	}

}
