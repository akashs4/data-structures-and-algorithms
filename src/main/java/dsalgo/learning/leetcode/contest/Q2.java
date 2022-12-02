package dsalgo.learning.leetcode.contest;

import java.util.HashMap;
import java.util.TreeMap;

public class Q2 {
    public static void main(String[] args) {
        int[] nums = {14, 7, 7, 7, 12, 7};
        int k = 2;
        System.out.println(maximumSubarraySum(nums, k));
        TreeMap<Integer, Integer> map = new TreeMap<>();

    }


    public static long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        int n = nums.length;

        // with k=1, find max number in array
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        long currentSum = 0;
        for (int i = 0; i < k; i++) {
            map.compute(nums[i], (key, val) -> (val == null) ? 1 : val + 1);

            right = i;
            currentSum += nums[i];
        }


        while (right < n) {
            if (map.size() == k)
                maxSum = Math.max(maxSum, currentSum);

            currentSum -= nums[left];
            if (map.get(nums[left]) == 1)
                map.remove(nums[left]);
            else {
                int temp = map.get(nums[left]);
                map.put(nums[left], temp - 1);
            }
            left++;
            right++;
            if (right >= n)
                break;
            currentSum += nums[right];
            map.compute(nums[right], (key, val) -> (val == null) ? 1 : val + 1);
        }


        return maxSum;
    }
}

/*

currentSum -= nums[left++];
right++
currentSum +=nums[right];
set.add(nums[right])

*
* if(size == k){
* maxSum = Math.max(currentSum, maxSum);
*
*
* */
