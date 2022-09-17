package dsalgo.learning.geeksforgeeks.binarytree;

public class Basic_5_SizeOfBinaryTree {
  public static int getSize(Node root) {
    return (root == null) ? 0 : 1 + getSize(root.left) + getSize(root.right);
  }
}
