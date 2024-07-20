package dsalgo.learning.clrs.ch02;

public class NonIncreasingInsertionSort {
    public void sort(int[] arr) {
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
