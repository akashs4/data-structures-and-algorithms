package dsalgo.learning.leetcode.array.easy;

// https://leetcode.com/problems/search-insert-position/description/
public class Easy_9_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    // 1 3 5 6, target-> 5,2,7
    private int helper(int[] nums, int start, int end, int target) {
        if (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                return helper(nums, start, mid - 1, target);
            else
                return helper(nums, mid + 1, end, target);
        } else {
            return end + 1;
        }
    }

    public static void main(String[] args) {
        Easy_9_SearchInsertPosition obj = new Easy_9_SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        System.out.println(obj.searchInsert(nums, target));
    }
}
