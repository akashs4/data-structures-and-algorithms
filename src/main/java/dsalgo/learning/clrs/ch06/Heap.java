package dsalgo.learning.clrs.ch06;

public class Heap {

    public static int left(int index) {
        return 2 * index + 1;
    }

    public static int right(int index) {
        return 2 * (index + 1);
    }

    public static int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * Assumes that binary trees at left(index), right(index) are max heaps.
     * But arr[index] might be smaller than its children.
     * Function aims to float down the value at arr[index] in max heap, so that
     * subtree rooted at given index satisfies max heap property
     * Given arr has values starting from index 0
     * <p>
     * Algo for solving: Find index having the largest value out of 3, parent, left child and right child
     * Replace value at parent with the largest index and recursively call the function using this largest index
     */
    public static void maxHeapify(int[] arr, int index, int heapSize) {
        int left = left(index);
        int right = right(index);

        int largest = index;

        if (left < heapSize && arr[left] > arr[index])
            largest = left;

        if (right < heapSize && arr[right] > arr[largest])
            largest = right;


        if (largest != index) {
            // swap values from index to largest
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = temp;

            maxHeapify(arr, largest, heapSize);
        }
    }

    public static void iterativeMaxHeapify(int[] arr, int index) {
        int heapSize = arr.length;
        while (true) {
            int left = left(index);
            int right = right(index);

            int largest = index;
            if (left < heapSize && arr[left] > arr[index])
                largest = left;

            if (right < heapSize && arr[right] > arr[largest])
                largest = right;

            if (largest != index) {
                // swap values from index to largest
                int temp = arr[largest];
                arr[largest] = arr[index];
                arr[index] = temp;

                index = largest;
            } else break;
        }
    }

    public static void minHeapify(int[] arr, int index, int heapSize) {
        int left = left(index);
        int right = right(index);
        int smallest = index;

        if (left < heapSize && arr[left] < arr[index])
            smallest = left;
        if (right < heapSize && arr[right] < arr[smallest])
            smallest = right;

        if (smallest != index) {
            int temp = arr[smallest];
            arr[smallest] = arr[index];
            arr[index] = temp;


            minHeapify(arr, smallest, heapSize);
        }
    }

    /**
     * Note: In array representation for storing n-element heap, the leaves are nodes indexed by n/2 +1, n/2 +2, ...... n-1
     */
    public static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--)
            maxHeapify(arr, i, arr.length);
    }

    /**
     * 1. Build max heap
     * 2. find max element
     * 3. replace it with A[n]
     * 4. decrease heap size
     * 5. call heapify on root -> O(logn)
     */
    public static void heapSort(int[] arr) {
        buildMaxHeap(arr);
        int heapSize = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            int max = arr[0];
            arr[0] = arr[i];
            arr[i] = max;

            heapSize--;
            maxHeapify(arr, 0, heapSize);
        }
    }
}
