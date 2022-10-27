package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class Easy_9_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
//        if (root == null)
//            return 0;
//
//        int leftDepth = maxDepth(root.left);
//        int rightDepth = maxDepth(root.right);
//
//        return 1 + Math.max(leftDepth, rightDepth);

        return root == null ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }
}
