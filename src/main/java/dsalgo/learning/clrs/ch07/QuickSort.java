package dsalgo.learning.clrs.ch07;

public class QuickSort {

    private QuickSort() {
    }

    public static void sort(int[] arr) {
        helperSort(arr, 0, arr.length - 1);
    }

    private static void helperSort(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(arr, start, end);
            helperSort(arr, start, partitionIndex - 1);
            helperSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int randomIndex = start + (int) (Math.random() * (end - start + 1));
        exchange(arr, randomIndex, end);

        int i = start - 1;
        int x = arr[end];
        for (int j = start; j < end; j++) {
            if (arr[j] <= x)
                exchange(arr, ++i, j);
        }

        exchange(arr, ++i, end);
        return i;
    }

    private static void exchange(int[] arr, int index, int otherIndex) {
        int temp = arr[index];
        arr[index] = arr[otherIndex];
        arr[otherIndex] = temp;
    }

    private static void improvedHelperSort(int[] arr, int start, int end) {
        while (start < end) {
            int partitionIndex = partition(arr, start, end);
            // Making sure to recurse for the smaller sub array to avoid too much stack depth
            if (partitionIndex - start < end - partitionIndex) {
                improvedHelperSort(arr, start, partitionIndex - 1);
                start = partitionIndex + 1;
            } else {
                improvedHelperSort(arr, partitionIndex + 1, end);
                end = partitionIndex - 1;
            }
        }
    }
}
