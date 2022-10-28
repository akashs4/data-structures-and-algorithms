package dsalgo.learning.leetcode.binarytree;

import java.util.Stack;

// Problem: https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
public class Medium_5_SumOfNodesWithEvenValuedGrandParent {

    private Stack<TreeNode> grandParents = new Stack<>();
    private int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        pre(root, -1, -1);
        return sum;
    }

    private void pre(TreeNode node, int parent, int grandParent) {
        if (node == null)
            return;

        if (grandParent % 2 == 0)
            sum += node.val;

        pre(node.left, node.val, parent);
        pre(node.right, node.val, parent);

    }
}
