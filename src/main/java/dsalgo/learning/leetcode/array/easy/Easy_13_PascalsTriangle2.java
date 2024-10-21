package dsalgo.learning.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

// Problem url: https://leetcode.com/problems/pascals-triangle-ii/
public class Easy_13_PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        int roww = rowIndex + 1;
        int temp = 1;
        long longNum;
        for (int col = 1; col < roww; col++) {
            longNum = temp;
            int difference = roww - col;
            temp = (int) ( (longNum * difference) / col);
            row.add(temp);
        }

        return row;
    }
}
