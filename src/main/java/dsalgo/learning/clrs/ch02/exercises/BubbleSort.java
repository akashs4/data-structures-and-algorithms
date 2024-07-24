package dsalgo.learning.clrs.ch02.exercises;

// After ith iteration, starting i elements are sorted
public class BubbleSort {
    private BubbleSort() {}

    public static void sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
