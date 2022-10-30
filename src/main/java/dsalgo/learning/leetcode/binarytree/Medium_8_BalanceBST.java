package dsalgo.learning.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

// Problem: https://leetcode.com/problems/balance-a-binary-search-tree/
public class Medium_8_BalanceBST {

    private List<Integer> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        if (height(root) != -1)
            return root;

        inOrder(root);
        return constructBSTFromSortedList(list);
    }

    private TreeNode constructBSTFromSortedList(List<Integer> list) {
        int n = list.size();
        if (n == 0)
            return null;

        return helper(list, 0, n - 1);
    }

    private TreeNode helper(List<Integer> nums, int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;
        TreeNode newNode = new TreeNode(nums.get(mid));
        newNode.left = helper(nums, start, mid - 1);
        newNode.right = helper(nums, mid + 1, end);

        return newNode;
    }


    private void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
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

        if (Math.abs(lH - rH) > 1)
            return -1;

        return 1 + Math.max(lH, rH);
    }

}
/*
 * Idea:
 * check if current tree is balanced already
 * if yes, return current root
 * else
 * perform inorder and store the nodes in a list -> this gives a list of nodes in sorted order (based on value in nodes)
 * (Reason of storing nodes in list and not values, we'll be reusing the nodes given in current tree
 * and also saving us the time of creating new node in each recursive call)
 * Create a helper method to create BST from above list recursively
 * */
