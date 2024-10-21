package dsalgo.learning.leetcode.array.easy;

// Problem url: https://leetcode.com/problems/remove-element/
public class Easy_8_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;

        if (n == 0)
            return 0;

        int left = 0, right = 0;

        while (right < n) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
            right++;
        }

        return left;
    }
}
