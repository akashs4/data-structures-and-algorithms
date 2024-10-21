package dsalgo.learning.clrs.ch06;

import java.util.NoSuchElementException;

public class MaxPriorityQueue {
    /**
     * Operations of max Priority Queue
     * 1. Max(A) - returns element of S with largest key
     * 2. ExtractMax(A) - removes and returns the element with the largest key
     * 3. increaseKey(A, x, k) - increase the value of element x's key to the passed new value (assuming passed value is >= current value)
     * 4. insert(A,x) - insert element x into the heap
     */

    public int heapMaximum(int[] arr) {
        return arr[0];
    }

    /**
     * Summary:
     * 1. Store the max value at arr[0] in a variable
     * 2. Copy value at last index to arr[0]
     * 3. Decrease heap size
     * 4. Call max heapify on root index
     */
    public int heapExtractMax(int[] arr, int heapSize) {
        if (heapSize == 0)
            throw new NoSuchElementException("Heap underflow");
        int max = arr[0];
        arr[0] = arr[heapSize - 1];
        heapSize--;
        Heap.maxHeapify(arr, 0, heapSize);
        return max;
    }

    /**
     * x - is index and array indices start from 0
     * Summary:
     * 1. Check if passed value is valid for heapIncreaseKey method
     * 2. Update the value at index with new value
     * 3. Compare the value at current index with its parent
     * 4. If value at parent is less, swap the value and update index value to parentIndex
     * 5. Keep doing this as long as each parent has less value than passed value
     * 6. If reached top, we can stop, since, no reason to continue anymore, value at parent would have already been swapped in previous step
     */
    public void heapIncreaseKey(int[] arr, int index, int value) {
        if (value < arr[index])
            throw new IllegalArgumentException("New key value can not be less than current value");

        arr[index] = value;

        while (index > 0 && arr[Heap.parent(index)] < arr[index]) {
            int parentIndex = Heap.parent(index);

            int temp = arr[parentIndex];
            arr[parentIndex] = arr[index];
            arr[index] = temp;

            index = parentIndex;
        }
    }

    /**
     * New value to be inserted into max heap
     * Summary:
     * 1. Increase heap size
     * 2. Insert passed value to last index of array
     * 3. Call heapIncreaseKey() on last index, which will float the value to appropriate place
     */
    public void insert(int[] arr, int value, int heapSize) {
        heapSize++;
        arr[heapSize - 1] = value;
        heapIncreaseKey(arr, heapSize - 1, value);
    }

    public static void main(String[] args) {
        MaxPriorityQueue pq = new MaxPriorityQueue();
        int[] arr = {};


    }
}
