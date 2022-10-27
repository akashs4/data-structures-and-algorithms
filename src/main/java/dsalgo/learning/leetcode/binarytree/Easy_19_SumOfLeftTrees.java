package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/sum-of-left-leaves/
public class Easy_19_SumOfLeftTrees {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return sum;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;

        TreeNode left = root.left;

        if (left != null && left.left == null && left.right == null)
            sum += left.val;

        helper(root.left);
        helper(root.right);
    }
}

/*
Algo:
-Perform pre order traversal
-before moving on to children, check if left child is not null and leaf node, then add left child's value to global variable
-return global variable from main method
* */
