package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/deepest-leaves-sum/
public class Medium_1_DeepestLeavesSum {
//    public int deepestLeavesSum(TreeNode root) {
//        LinkedList<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//
//        int lastLevelSum = 0, currentLevelSum = 0;
//        while (!q.isEmpty()) {
//            int n = q.size();
//
//            for (int i = 0; i < n; i++) {
//                TreeNode temp = q.poll();
//                currentLevelSum += temp.val;
//                if (temp.left != null)
//                    q.offer(temp.left);
//                if (temp.right != null)
//                    q.offer(temp.right);
//            }
//
//            lastLevelSum = currentLevelSum;
//            currentLevelSum = 0;
//        }
//
//        return lastLevelSum;
//    }

    private int maxLevel = 0;
    private int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int level) {
        if (root == null)
            return;

        if (level > maxLevel) {
            sum = 0;
            maxLevel = level;
        }
        if (level == maxLevel)
            sum += root.val;

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
/*
 * Iterative Approach using BFS:
 * calculate sum of each level
 * store it in lastLevelSum variable before moving on to next level
 * in the end we can just return lastLevelSum variable value
 *
 * Recursive Approach:
 * create a helper method, we pass reference to node and level information in this helper method
 * if current level is greater than the max level seen so far, reset sum to 0 and update current level as max level
 * we do the same for LST and then for RST
 *
 * */
