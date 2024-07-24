package dsalgo.learning.clrs.ch02;

public class MergeSort {

    private MergeSort() {
    }

    /**
     * arr - input array to be sorted
     * start - start index
     * end - end index
     */
    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        System.arraycopy(arr, start, leftArr, 0, leftSize);
        System.arraycopy(arr, mid + 1, rightArr, 0, rightSize);

        int i = 0;
        int j = 0;
        int k = start;

        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j])
                arr[k++] = leftArr[i++];
            else arr[k++] = rightArr[j++];
        }

        while (i < leftSize)
            arr[k++] = leftArr[i++];
        while (j < rightSize)
            arr[k++] = rightArr[j++];
    }
}
