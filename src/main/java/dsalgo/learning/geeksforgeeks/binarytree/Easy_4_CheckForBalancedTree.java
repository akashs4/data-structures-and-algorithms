package dsalgo.learning.geeksforgeeks.binarytree;

/* Problem Description: Given a binary tree, find if it is height balanced or not.
A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree */
public class Easy_4_CheckForBalancedTree {

  boolean isBalanced = true;

  public boolean isBalanced(Node node) {
    if (node == null) return false;

    height(node);

    return isBalanced;
  }

  private int height(Node node) {
    if (node == null) return 0;

    if (!isBalanced) return -1;

    int leftHeight = height(node.left);
    int rightHeight = height(node.right);

    isBalanced = isBalanced && (Math.abs(leftHeight - rightHeight) > 1);

    return 1 + Math.max(leftHeight, rightHeight);
  }
}
