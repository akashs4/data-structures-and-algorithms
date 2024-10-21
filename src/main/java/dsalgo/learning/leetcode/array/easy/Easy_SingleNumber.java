package dsalgo.learning.leetcode.array.easy;

// Problem url : https://leetcode.com/problems/single-number/description/
public class Easy_SingleNumber {
    public int singleNumber(int[] nums) {
        int singleNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            singleNum = singleNum ^ nums[i];
        }

        return singleNum;
    }
}
