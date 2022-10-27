package dsalgo.learning.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

// Problem: https://leetcode.com/problems/find-mode-in-binary-search-tree/
// TODO: solve using optimized version, where we keep track of last node visited, current count and max count seen so far
public class Easy_25_ModeInBST {

    private TreeNode pre;
    private int currCount = 1;
    private int maxCount = 1;
    private List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        helper(root);
        int n = result.size();

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;

        helper(root.left);

        if (pre != null) {
            if (pre.val == root.val) {
                currCount++;
            } else currCount = 1;
        }

        if (currCount > maxCount) {
            result.clear();
            result.add(root.val);
            maxCount = currCount;
        } else if (currCount == maxCount) {
            result.add(root.val);
        }

        pre = root;

        helper(root.right);
    }

}

/*
situations we come across first time
pre is null -> no node visited before, currcount and maxCount are 0

pre is not null -> have visited some node before
    ->current node can be same as last node -> will have to increase the count

* */
