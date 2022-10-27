package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/range-sum-of-bst/
public class Easy_3_RangeSumOfBST {
    public int rangeSumBST(TreeNode node, int low, int hi) {
        if (node == null)
            return 0;
        if (node.val <= low)
            return (node.val == low ? node.val : 0) + rangeSumBST(node.right, low, hi);
        if (node.val >= hi)
            return (node.val == hi ? node.val : 0) + rangeSumBST(node.left, low, hi);

        return node.val + rangeSumBST(node.left, low, hi) + rangeSumBST(node.right, low, hi);
    }
}
