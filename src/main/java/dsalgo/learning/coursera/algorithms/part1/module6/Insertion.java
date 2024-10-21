package dsalgo.learning.coursera.algorithms.part1.module6;

import java.util.Comparator;

/**
 * Insertion sort runs in linear time for partially sorted arrays
 * Reason: Number of exchanges = number of inversions
 * Inversion: when i is less than j and arr[i] > arr[j]
 * */
public class Insertion {

	private Insertion() {
	}

	public static void sort(Object[] arr, Comparator comparator) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && less(comparator, arr[j], arr[j - 1]); j--)
				exch(arr, j, j - 1);
		}
	}

	private static boolean less(Comparator comparator, Object a, Object b) {
		return comparator.compare(a, b) < 0;
	}

	private static void exch(Object[] arr, int index, int otherIndex) {
		Object swap = arr[index];
		arr[index] = arr[otherIndex];
		arr[otherIndex] = swap;
	}

	public static void sort(Comparable[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
					exch(arr, j, j - 1);
			}
		}
	}

	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
}
