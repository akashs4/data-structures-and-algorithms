package dsalgo.learning.leetcode.array;

import java.lang.management.ManagementPermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Problem: https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
public class Easy_1_FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int value = 0;
        String x = "";
        x.charAt(0);

        for (String operation : operations) {
            if (operation.charAt(0) == 'X') {
                // either plus or minus now
                if (operation.charAt(1) == '+')
                    value++;
                else value--;
            } else if (operation.charAt(0) == '+')
                value++;
            else value--;
        }

        return value;
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n - 2][n - 2];

        for (int r = 0; r < n - 2; r++) {
            for (int c = 0; c < n - 2; c++) {
                int max = grid[r][c];
                // loop over 3X3 matrix
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        max = (grid[i][j] > max) ? grid[i][j] : max;
                    }
                }
                result[r][c] = max;
            }
        }

        return result;
    }

    public int numIdenticalPairs(int[] nums) {
        int pairs = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++)
            countMap.compute(nums[i], (key, value) -> (value == null) ? 1 : value + 1);

        for (int value : countMap.values()) {
            if (value > 1) {
                pairs += (value * (value - 1)) / 2;
            }
        }
        return pairs;
    }

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];

        int k = 0;
        for (int i = 0, j = n; i < n && j < 2 * n; i++, j++) {
            result[k++] = nums[i];
            result[k++] = nums[j];
        }
        System.gc();
        return result;
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) >= 0)
                indices.add(i);
        }
        return indices;
    }

    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 3 != 0)
                count++;
        }
        return count;
    }
}

/*Idea:
 * Compare only the characters, since it'll save time
 * because there are only 4 possible operations:
 * X++, X--
 * ++X, --X
 * */
