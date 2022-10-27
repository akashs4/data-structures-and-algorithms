package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/balanced-binary-tree/
public class Easy_24_BalancedBST {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int h = height(root);

        return h != -1;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;

        int lH = height(root.left);

        if (lH == -1)
            return -1;
        int rH = height(root.right);
        if (rH == -1)
            return -1;

        if (Math.abs(lH = rH) > 1) {
            return -1;
        }

        return 1 + Math.max(lH, rH);
    }
}
