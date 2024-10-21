package dsalgo.learning.leetcode.array.easy;

// Problem: https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
public class Easy_6_SumOfAllOddLengthSubArrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0, n = arr.length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++)
            prefixSum[i] = (i > 0 ? prefixSum[i - 1] : 0) + arr[i];


        int length = 3;

        int left = 0, right = left + length - 1;
        while (right < n) {

        }


        return sum;
    }
}
