package dsalgo.learning.clrs.ch02.exercises;

// Exercise - 2.3

public class IterativeBinarySearch {

    private IterativeBinarySearch() {
    }

    /**
     * A - sorted array with unique elements
     */
    public static int search(int[] arr, int item) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == item)
                return mid;

            if (arr[mid] > item)
                end = mid - 1;

            if (arr[mid] < item)
                start = mid + 1;
        }
        return -1;
    }
}
