package dsalgo.learning.coursera.algorithms.part1.module6;

public class Merge {

    private Merge() {
    }

    public void sort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);
        assert isSorted(arr, 0, arr.length - 1);
    }

    /**
     * Skip the merge operation if first element in second half is greater than or
     * equal to last element in first half
     * */
    private static void mergeSort(Comparable[] arr, Comparable[] aux, int start, int end) {
        int mid = (start + end) / 2;

        if (start < end) {
            mergeSort(arr, aux, start, mid);
            mergeSort(arr, aux, mid + 1, end);

            if (!less(arr[mid + 1], arr[mid]))
                return;
            merge(arr, aux, start, mid, end);
        }
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int start, int mid, int end) {
        assert isSorted(arr, start, mid);
        assert isSorted(arr, mid + 1, end);
        int i = start, j = mid + 1;

        for (int k = start; k <= end; k++)
            aux[k] = arr[k];

        for (int k = start; k <= end; k++) {
            if (i > mid) {
                arr[k++] = aux[j++];
            } else if (j > end) {
                arr[k++] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
            }
        }

        assert isSorted(arr, start, end);
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static boolean isSorted(Comparable[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            if (less(arr[i + 1], arr[i]))
                return false;
        }
        return true;
    }
}
