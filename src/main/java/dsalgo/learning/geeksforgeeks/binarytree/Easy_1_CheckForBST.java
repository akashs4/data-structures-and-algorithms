package dsalgo.learning.geeksforgeeks.binarytree;

/* Problem Description: Check for BST */
public class Easy_1_CheckForBST {

  public boolean isBST(Node root) {
    // can also use null values in place of min and max, to avoid particular range
    return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  boolean helper(Node root, int min, int max) {
    if (root == null) return true;

    if (root.data <= min || root.data >= max) return false;

    return helper(root.left, min, root.data) && helper(root.right, root.data, max);
  }
}
