import java.util.HashMap;
import java.util.Scanner;

public class OrganicChemistry {

	private static HashMap<Character, Integer> compoundValue = new HashMap<Character, Integer>();

	private static void initCompoundValue() {
		compoundValue.put('C', 12);
		compoundValue.put('O', 16);
		compoundValue.put('H', 1);
		compoundValue.put('c', 12);
		compoundValue.put('o', 16);
		compoundValue.put('h', 1);
	}

	public static void main(String[] args) {
		initCompoundValue();
		String compound;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter compound: ");
		compound = in.nextLine();
		int molecularMass = 0;
		for (int i = 0; i < compound.length(); i++) {
			if ((i + 1) >= compound.length()
					&& Character.isAlphabetic(compound.charAt(i))) {
				molecularMass += compoundValue.get(compound.charAt(i));
				break;
			}

			if (compound.charAt(i) == '(') {
				i++;
				int temp = 0;
				int num = 0;
				while (compound.charAt(i) != ')') {
					if (Character.isDigit(compound.charAt(i + 1))) {
						int n = Integer.parseInt(String.valueOf(compound
								.charAt(i + 1)));
						temp += compoundValue.get(compound.charAt(i)) * n;
						i++;
					} else {
						temp += compoundValue.get(compound.charAt(i));
					}
					i++;
				}
				// at ')'
				i++;
				// multiplying with num
				num = Integer.parseInt(String.valueOf(compound.charAt(i)));
				molecularMass += (num * temp);
				continue;

			}
			// next char is digit
			else if (Character.isDigit(compound.charAt(i + 1))) {
				int num = Integer.parseInt(String.valueOf(compound
						.charAt(i + 1)));
				molecularMass += compoundValue.get(compound.charAt(i)) * num;
				i++;
			}
			// next is alphabet or open bracket '('
			else if (Character.isAlphabetic(compound.charAt(i))
					|| compound.charAt(i + 1) == '('
					|| Character.isAlphabetic(compound.charAt(i))) {
				molecularMass += compoundValue.get(compound.charAt(i));
			}
		}

		System.out.println("\nMolecular Mass: " + molecularMass);

		in.close();
	}
}
