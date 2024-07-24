package dsalgo.learning.clrs.ch02.exercises;

// Exercise - 2.3
public class RecursiveBinarySearch {
    private RecursiveBinarySearch() {
    }

    public static int search(int[] arr, int item, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if (arr[mid] == item)
            return mid;

        if (arr[mid] > item)
            return search(arr, item, start, mid - 1);

        return search(arr, item, mid + 1, end);
    }
}
