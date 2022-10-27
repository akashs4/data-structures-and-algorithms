package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/subtree-of-another-tree/
public class Easy_26_SubTreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (areSame(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean areSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;

        return areSame(root.left, subRoot.left) && areSame(root.right, subRoot.right);
    }
}
