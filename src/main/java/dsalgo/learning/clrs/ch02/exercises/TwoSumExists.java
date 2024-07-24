package dsalgo.learning.clrs.ch02.exercises;

import dsalgo.learning.clrs.ch02.MergeSort;

/**
 * Given a set of n integers and a number x, determine whether or not there exist 2 elements in given set whose sum is equal to x
 */
// Exercise - 2.3
public class TwoSumExists {

    private TwoSumExists() {
    }

    public static boolean check(int[] arr, int x) {
        int n = arr.length;
        MergeSort.sort(arr, 0, n - 1); // Takes O(nlogn)

        boolean result = false;
        for (int left = 0, right = n - 1; left < right; ) {
            if (arr[left] + arr[right] == x) {
                result = true;
                break;
            } else if (arr[left] + arr[right] < x) {
                left++;
            } else if (arr[left] + arr[right] > x) {
                right--;
            }
        }

        return result;
    }
}
