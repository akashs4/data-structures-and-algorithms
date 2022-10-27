package dsalgo.learning.leetcode.binarytree;

public class Easy_22_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return symmetricChecker(root.left, root.right);
    }

    private boolean symmetricChecker(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)
            return true;
        if (r1 == null || r2 == null)
            return false;
        if (r1.val != r2.val)
            return false;

        return symmetricChecker(r1.left, r1.right) && symmetricChecker(r1.right, r2.left);
    }
}
