package dsalgo.learning.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Easy_10_AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            double total = 0;
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                total += temp.val;
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            result.add(total/n);
        }

        return result;
    }
}
