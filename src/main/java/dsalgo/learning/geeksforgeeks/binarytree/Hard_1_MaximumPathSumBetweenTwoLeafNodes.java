package dsalgo.learning.geeksforgeeks.binarytree;

// Problem Description: Maximum path sum between two leaf nodes
public class Hard_1_MaximumPathSumBetweenTwoLeafNodes {
  private int sum = Integer.MIN_VALUE;

  public int maxPathSum(Node root) {
    maxSum(root, 0);
    return sum;
  }

  private int maxSum(Node node, int lvl) {
    if (node == null) return 0;

    if (node.left == null && node.right == null) return node.data;

    int leftSum = maxSum(node.left, lvl + 1);
    int rightSum = maxSum(node.right, lvl + 1);

    // if condition to exclude root from below operations because root also comes
    // under definition of leaf node in current problem
    if (lvl != 0) {
      if (node.left == null) return node.data + rightSum;
      else if (node.right == null) return node.data + leftSum;
    }

    sum = Math.max(sum, leftSum + rightSum + node.data);

    return node.data + Math.max(leftSum, rightSum);
  }
}
