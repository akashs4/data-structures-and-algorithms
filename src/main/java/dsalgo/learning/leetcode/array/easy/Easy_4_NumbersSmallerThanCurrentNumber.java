package dsalgo.learning.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Problem: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
public class Easy_4_NumbersSmallerThanCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] copy = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        System.arraycopy(nums, 0, copy, 0, n);
        Arrays.sort(copy);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], count);
            }
            count++;
        }

        for (int i = 0; i < n; i++)
            result[i] = map.get(nums[i]);

        return result;
    }
}
