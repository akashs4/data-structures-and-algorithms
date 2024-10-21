package dsalgo.learning.leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem url: https://leetcode.com/problems/pascals-triangle/description/
public class Easy_12_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        pascalsTriangle.add(List.of(1));

        for (int i = 1; i < numRows; i++) {
            Integer[] temp = new Integer[i + 1];
            for (int j = 0; j <= i; j++) {
                int val = (j == 0 ? 0 : pascalsTriangle.get(i - 1).get(j - 1)) + (j > i - 1 ? 0 : pascalsTriangle.get(i - 1).get(j));
                temp[j] = val;
            }
            pascalsTriangle.add(Arrays.asList(temp));
        }

        return pascalsTriangle;
    }

    public static void main(String[] args) {
        Easy_12_PascalsTriangle obj = new Easy_12_PascalsTriangle();
        List<List<Integer>> list = obj.generate(5);

        System.out.println(list);

    }
}

/**
 * 1
 * 1 1 -> arr[i][j] = arr[i-1][j-1] + arr[i-1][j]
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * <p>
 * 1 0 0 0 0
 * 1 1 0 0 0
 * 1 2 1 0 0
 * 1 3 3 1 0
 * 1 4 6 4 1
 */
