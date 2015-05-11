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
			selectionSort();
			printMenu();
			break;
		case "c":
			insertionSort();
			printMenu();
			break;
		case "d":
			quickSort();
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

	public void quickSort() {
		int[] array = { 3, 2, 1, 2, 9, 4, 8, 11, 10, 7, 6, 1, 5 };
		System.out.println("Quick Sort:");
		System.out.println(arrayToString(array));
		int start = 0;
		int end = array.length - 1;
		quickSortSort(array, start, end);
		System.out.println("Worst case time-complexity: O(n^2)\nAverage case time-complexity: O(nlogn)");
		System.out.println();
	}

	public void quickSortSort(int[] array, int start, int end) {
		if (start < end) {
			int partitionIndex = quickSortPartition(array, start, end);
			quickSortSort(array, start, partitionIndex - 1);
			quickSortSort(array, partitionIndex + 1, end);
			System.out.println(arrayToString(array));
		} else {
			// finished
		}
	}

	public int quickSortPartition(int[] array, int start, int end) {
		int storedIndex = start;
		int pivotIndex = end;
		int pivotValue = array[end];
		for (int i = start; i < end; i++) {
			if (array[i] < pivotValue) {
				int a = array[i];
				int b = array[storedIndex];
				array[storedIndex] = a;
				array[i] = b;
				storedIndex++;
			}
		}
		int a = array[pivotIndex];
		int b = array[storedIndex];
		array[storedIndex] = a;
		array[pivotIndex] = b;
		return storedIndex;
	}

	public void insertionSort() {
		int[] array = { 3, 10, 1, 2, 9, 8, 2, 5, 7, 6 };
		System.out.println("Insertion Sort:");
		System.out.println(arrayToString(array));
		for (int i = 1; i < array.length; i++) {
			int value = array[i];
			int hole = i;
			while ((hole > 0) && (array[hole - 1] > value)) {
				array[hole] = array[hole - 1];
				hole--;
			}
			array[hole] = value;
			System.out.println(arrayToString(array));
		}
		System.out.println("Worst case time-complexity: O(n^2)");
		System.out.println();
	}

	public void selectionSort() {
		int[] array = { 3, 10, 1, 2, 9, 8, 2, 5, 7, 6 };
		System.out.println("Selection Sort:");
		System.out.println(arrayToString(array));
		int divider = 0;
		int minNum = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			minNum = Integer.MAX_VALUE;
			divider = i;
			int minIndex = divider;
			for (int j = divider; j < array.length; j++) {
				if (minNum > array[j]) {
					minNum = array[j];
					minIndex = j;
				}
			}
			int a = array[divider];
			int b = array[minIndex];
			array[minIndex] = a;
			array[divider] = b;
			System.out.println(arrayToString(array));
		}
		System.out.println("Worst case time-complexity: O(n^2)");
		System.out.println();
	}

	public void bubbleSort() {
		int[] array = { 3, 10, 1, 2, 9, 8, 2, 5, 7, 6 };
		System.out.println("Bubble Sort:");
		System.out.println(arrayToString(array));
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int a = array[j];
					int b = array[j + 1];
					array[j + 1] = a;
					array[j] = b;
				}
				// Uncomment the following line out to view all n^2 outputs
				// System.out.println(arrayToString(array));
			}
			System.out.println(arrayToString(array));
		}
		System.out
				.println("Worst case time-complexity: O(n^2)\nTo see all n^2 outputs, uncomment out the System.out.print in bubbleSort()");
		System.out.println();
	}

	public String arrayToString(int[] array) {
		String ret = "|";
		for (int i = 0; i < array.length; i++) {
			ret += array[i] + "|";
		}
		return ret;
	}
}
