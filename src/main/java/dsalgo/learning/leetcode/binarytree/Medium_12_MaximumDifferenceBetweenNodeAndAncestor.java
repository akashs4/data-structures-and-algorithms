package dsalgo.learning.leetcode.binarytree;

import java.util.Stack;

// Problem: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
public class Medium_12_MaximumDifferenceBetweenNodeAndAncestor {
    private int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        Stack<Integer> ancestors = new Stack<>();

        height(root, root.val, root.val);

        return maxDiff;
    }

    // TC: O(n), SC: O(n)
    private void height(TreeNode root, int maxAncestor, int minAncestor) {
        if (root == null)
            return;

        maxAncestor = Math.max(maxAncestor, root.val);
        minAncestor = Math.min(minAncestor, root.val);

        maxDiff = Math.max(maxDiff, Math.abs(maxAncestor - root.val));
        maxDiff = Math.max(maxDiff, Math.abs(minAncestor - root.val));

        height(root.left, maxAncestor, minAncestor);
        height(root.right, maxAncestor, minAncestor);
    }

    // Brute Force
//    private void height(TreeNode root, Stack<Integer> ancestors) {
//        if (root == null)
//            return;
//
//        for (Integer ancestor : ancestors)
//            maxDiff = Math.max(maxDiff, ancestor - root.val);
//
//        ancestors.push(root.val);
//        height(root.left, ancestors);
//        height(root.right, ancestors);
//
//        ancestors.pop();
//    }
}

/*Idea:

Optimized Approach:
Key idea is max diff can only be obtained with either max ancestor value or min ancestor value seen so far
No need to go through the values in the middle of min and max ancestor values
 *
 * Brute force approach
 * pass ancestor stack containing all ancestor values
 * in each recursive call, iterate over stack and keep updating max diff in maxDiff variable
 * recursive call for left and right child with current root value added in ancestor stack
 * before exiting from method, perform stack.pop()
 * */
