package dsalgo.learning.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

// Problem: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
public class Medium_2_CountNodesEqualToAverageOfSubTree {

    private Map<Integer, Integer> sumMap = new HashMap<>();
    private Map<Integer, Integer> countMap = new HashMap<>();


    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;

        int temp = 0;
        TreeNode left = root.left;
        int leftSum = 0, leftCount = 0;
        if (left != null) {
            leftSum = sum(left);
            leftCount = count(left);
        }
        TreeNode right = root.right;
        int rightSum = 0, rightCount = 0;
        if (left != null) {
            rightSum = sum(left);
            rightCount = count(left);
        }

        int totalSum = leftSum + rightSum + root.val;
        int totalCount = leftCount + rightCount + 1;

        return (totalSum / totalCount == root.val ? 1 : 0) + averageOfSubtree(root.left) + averageOfSubtree(root.right);
    }

    private int count(TreeNode node) {
        if (node == null) return 0;

        if (countMap.containsKey(node.val)) return countMap.get(node.val);
        else countMap.put(node.val, 1 + count(node.left) + count(node.right));

        return countMap.get(node.val);
    }

    private int sum(TreeNode node) {
        if (node == null) return 0;

        if (sumMap.containsKey(node.val)) return sumMap.get(node.val);
        else sumMap.put(node.val, node.val + sum(node.left) + sum(node.right));

        return sumMap.get(node.val);
    }
}

/*
 * Approach:
 * remember sum of nodes in subtree at that node, count of nodes in subtree at that node for every node in tree
 * one method for counting number of nodes in subtree
 * one method for finding sum of nodes in subtree
 *
 * countMap -> count of nodes in subtree at node(identified by key in map)
 * sumMap -> sum of nodes in subtree at node(identified by key in map)
 *
 * if root.left!=null -> check sum and count entries for left/right child in maps
 * if present, calculate average -> (root.val + sumMap.get(root.left.val) + sumMap(root.right.val) )/( 1 + countMap(root.left.val) + countMap(root.right.val))
 *
 * leftCount = count(root.left)
 * leftSum = sum(root.left)
 *
 * */
