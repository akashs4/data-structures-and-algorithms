package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/diameter-of-binary-tree/
public class Easy_20_DiameterOfBinaryTree {
    private int diam = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diam;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;

        int lH = height(root.left);
        int rH = height(root.right);

        diam = Math.max(diam, lH + rH);
        return 1 + Math.max(lH, rH);
    }
}

/*Algo
 * -At every node, we find maximum left height, right height
 * -Since, diameter is the longest possible path between two leaf nodes, so it's more like maximum of all possible lH+rH
 * -Since, perform diam=Math.max(lH, rH) at each node, we'll have maximum possible diameter stored in diam variable in the end
 * */