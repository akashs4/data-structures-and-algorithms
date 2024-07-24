package dsalgo.learning.clrs.ch02.exercises;

// Exercise - 2.3

public class IterativeBinarySearch {

    private IterativeBinarySearch() {
    }

    /**
     * A - sorted array with unique elements
     */
    public static int search(int[] A, int item) {
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (A[mid] == item)
                return mid;

            if (A[mid] > item)
                end = mid - 1;

            if (A[mid] < item)
                start = mid + 1;
        }
        return -1;
    }
}

/**
 * rough:
 * we find mid = (start+end)/2
 * if(A[mid] == item) -> return mid
 * otherwise 2 possibilities -> A[mid] > item or A[mid] < item
 * <p>
 * if(A[mid] < item) -> item is in range (mid+1) to end, -> start becomes mid+1 for next iteration
 * if(A[mid] > item) -> item is in range start to mid -> end becomes mid for next iteration
 * <p>
 * <p>
 * if(start <= end)
 * {
 * mid = (start+end)/2
 * <p>
 * if(A[mid] == item) -> return mid
 * <p>
 * if(A[mid] < item) -> start = mid+1; continue
 * if(A[mid] > item) -> end = mid-1; continue
 * <p>
 * }
 * <p>
 * return -1;
 * <p>
 * 0 1 2 3 4 5
 * 1 2 4 4 5 6
 */
