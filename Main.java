import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	private Scanner scanner;

	public static void main(String args[]) {
		new Main();
	}

	public Main() {
		scanner = new Scanner(System.in);
		printMenu();
	}

	public void printMenu() {
		System.out
				.println("Steve's Sick Sorting Algorithm Review\n(A) Bubble Sort\n(B) Selection Sort\n(C) Insertion Sort\n(D) Quick Sort\n(E) Merge Sort\n(F) Radix Sort\n(G) Merge Sort\n(H) Counting Sort\n(Q) Quit");
		inputListener();
	}

	public void inputListener() {
		String input = scanner.next();
		switch (input.toLowerCase()) {
		case "a":
			bubbleSort();
			printMenu();
			break;
		case "b":

			printMenu();
			break;
		case "q":
			System.out.println("Program shutting down.");
			System.exit(0);
			break;
		default:
			System.out.println("Input not recognized, please try again.\n");
			printMenu();
			break;
		}
	}

	public void bubbleSort() {
		System.out.println("Bubble Sort:\nBase Array:\n|3|10|1|2|9|8|2|5|7|6|");
		System.out.println();
	}
}
