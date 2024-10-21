package dsalgo.learning.leetcode.array.medium;

import java.util.HashMap;

// Problem: https://leetcode.com/problems/max-increase-to-keep-city-skyline/
public class Medium_2_MaxIncreaseToKeepCitySkyline {
    public static void main(String[] args) {
        int[][] test = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(maxIncreaseKeepingSkyline(test));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {

        HashMap<Integer, Integer> rowsMax = new HashMap<>();
        HashMap<Integer, Integer> colsMax = new HashMap<>();

        int n = grid.length;

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++)
                max = Math.max(max, grid[i][j]);

            rowsMax.put(i, max);
        }

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++)
                max = Math.max(max, grid[j][i]);
            colsMax.put(i, max);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = Math.min(rowsMax.get(i), colsMax.get(j));
                result += temp - grid[i][j];
            }
        }

        return result;
    }
}
