package dsalgo.learning.leetcode.binarytree;

// Problem:  https://leetcode.com/problems/univalued-binary-tree/
public class Easy_11_UnivaluedBinaryTree {

    private int val = -1;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        if (val < 0) val = root.val;

        return (val == root.val) && isUnivalTree(root.left) && isUnivalTree(root.right);

        // one-liner, uses the fact that at every node, value at node and value in children should be same
        // and corresponding sub trees on child nodes should be unival too
        // return (root.left == null || root.left.val == root.val && isUnivalTree(root.left)) &&
        // (root.right == null || root.right.val == root.val && isUnivalTree(root.right));
    }
}
