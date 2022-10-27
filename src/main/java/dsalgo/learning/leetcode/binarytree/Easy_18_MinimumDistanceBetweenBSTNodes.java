package dsalgo.learning.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class Easy_18_MinimumDistanceBetweenBSTNodes {

    private int minValue = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        pre(root, list);

        for(int i=0 ; i<list.size()-2 ; i++){
            int num1 = list.get(i);
            int num2 = list.get(i+1);
            minValue = Math.min(minValue, Math.abs(num1-num2));
        }

        return minValue;
    }

    private void pre(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);
        pre(root.left, list);
        pre(root.right, list);
    }
}
