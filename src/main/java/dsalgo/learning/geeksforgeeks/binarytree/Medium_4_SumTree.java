package dsalgo.learning.geeksforgeeks.binarytree;

/* Problem Description: Find whether given binary tree is sum tree or not i.e. if each node val is equal to
 * sum of values in left subtree and right subtree. This condition should be satisfied by all nodes except leaf nodes */
public class Medium_4_SumTree {

  public boolean isSumTree(Node root) {
    return sum(root) != -1;
  }

  private int sum(Node node) {
    if (node == null) return 0;

    if (node.left == null && node.right == null) return node.data;

    int lSum = sum(node.left);
    int rSum = sum(node.right);

    if (lSum == -1 || rSum == -1) return -1;

    if (lSum + rSum != node.data) return -1;

    return node.data + lSum + rSum;
  }
}

/*
 *   3
 * 1   2
 *
 *     5
 * 2
 *
 * */
