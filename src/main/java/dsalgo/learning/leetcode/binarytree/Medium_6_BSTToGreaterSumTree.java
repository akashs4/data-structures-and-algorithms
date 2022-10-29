package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
public class Medium_6_BSTToGreaterSumTree {

    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null)
            return null;

        bstToGst(root.right);
        root.val = sum + root.val;
        sum = root.val;
        bstToGst(root.left);

        return root;
    }
}

/*
 * Idea:
 * example:
 * 5
 *  6
 *      7
 *          8
 * if we reach 6, we need to know the sum of 7 and 8 in order to add to current value of 6
 * first calculate sum of all right children,
 * store them in sum variable
 * update current parent node's value to sum+value at node
 * call the recursive method for left child
 * */