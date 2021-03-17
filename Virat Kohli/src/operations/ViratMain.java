package operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ViratMain {

	public static void main(String[] args) {
		ArrayList<Integer> bowlList = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		int bowlsViratPlay;
		int totalBowlers;
		int totalBowls = 0;

		System.out.println("-----Cricket Match-----");
		System.out.println("\nEnter total bowls Virat will play:");
		bowlsViratPlay = in.nextInt();
		System.out.println("\nEnter total number of bowlers:");
		totalBowlers = in.nextInt();

		// input bowls for each bowler
		for (int i = 0; i < totalBowlers; i++) {
			System.out.println("\nEnter bowls left for B" + (i + 1) + ":");
			int bowls = in.nextInt();
			bowlList.add(bowls);
			totalBowls += bowls;
		}

		// display Virat and bowlers with their bowls left
		System.out.println("\nTotal bowls: " + totalBowls);
		System.out.println("\nBowls Virat will play: " + bowlsViratPlay + "\n");

		for (int i = 0; i < totalBowlers; i++) {
			System.out.println("Bowler B" + (i + 1) + ": " + bowlList.get(i));
		}

		// operation performed
		ArrayList<Integer> bowlerFormation = new ArrayList<Integer>();
		int index;
		if (totalBowls < bowlsViratPlay) {
			System.out.println("Bowls insufficient for Virat to play !");
		} else {
			while (bowlsViratPlay != 0) {
				index = bowlList.indexOf(Collections.max(bowlList));
				bowlerFormation.add((index + 1));
				bowlList.set(index, (bowlList.get(index) - 1));
				bowlsViratPlay--;
			}
			System.out.println("\nBowler formation: ");

			for (int i = 0; i < bowlerFormation.size(); i++) {
				System.out.println("B" + bowlerFormation.get(i));
			}

			System.out.println("\n-----Match Over-----");
		}

		in.close();
	}
}
