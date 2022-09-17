package dsalgo.learning.geeksforgeeks.binarytree;

/* Problem Description: Diameter of a binary tree i.e. number of nodes on longest path between two end nodes */
public class Easy_3_DiameterOfBinaryTree {

  int maxHeight = 0;

  public int diameter(Node node) {
    if (node == null) return 0;
    height(node);
    return maxHeight;
  }

  private int height(Node root) {
    if (root == null) return 0;

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    maxHeight = Math.max(maxHeight, leftHeight + rightHeight + 1);

    return 1 + Math.max(leftHeight, rightHeight);
  }
}
