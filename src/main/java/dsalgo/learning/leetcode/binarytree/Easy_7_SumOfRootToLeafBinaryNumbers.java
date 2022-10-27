package dsalgo.learning.leetcode.binarytree;

import java.util.Stack;

// Problem: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
// TODO: understand optimal solution which uses bitwise operation concept
public class Easy_7_SumOfRootToLeafBinaryNumbers {

    private Stack<Integer> stack = new Stack<>();
    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return sum;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;

        stack.push(root.val);
        if (isLeaf(root)) {
            // iterate over stack to extract number in string builder or buffer
            // pass the constructed string to a function which returns corresponding number from binary representation
            StringBuffer sb = new StringBuffer();
            for (Integer val : stack)
                sb.append(val);

            sum += getNumber(sb.toString());
        } else {
            traverse(root.left);
            traverse(root.right);
        }
        stack.pop();
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private int getNumber(String binaryRepresentation) {
        // 100101, size:6
        // i=size-1,
        int size = binaryRepresentation.length();
        int number = 0;
        for (int i = size - 1, j = 0; i >= 0; i--, j++) {
            int num = binaryRepresentation.charAt(j) - '0';
            number += num * Math.pow(2, i);
        }

        return number;
    }
}
