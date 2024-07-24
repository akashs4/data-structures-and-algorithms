package dsalgo.learning.clrs.ch02.exercises;

// Exercise - 2.1
public class NonIncreasingInsertionSort {

    private NonIncreasingInsertionSort() {
    }

    public static void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int item = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] < item) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = item;
        }
    }
}
