package dsalgo.learning.clrs.ch02.exercises;

// Exercise - 2.2
public class SelectionSort {

    private SelectionSort() {
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallestIndex])
                    smallestIndex = j;
            }

            // swap with ith position - If smallest at i index, swap happens with same position
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }

    }
}