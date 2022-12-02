package dsalgo.learning.leetcode.contest;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {

        System.out.println('d' - 'a');
    }

    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int zeros = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                zeros++;
            else {
                list.add(nums[i]);
            }
        }

        for (int i = 0; i < zeros; i++)
            list.add(0);

        for (int i = 0; i < n; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

}
