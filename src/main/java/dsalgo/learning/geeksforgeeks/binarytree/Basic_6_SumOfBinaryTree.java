package dsalgo.learning.geeksforgeeks.binarytree;

public class Basic_6_SumOfBinaryTree {
  public static int sumBT(Node root) {
    return (root == null) ? 0 : root.data + sumBT(root.left) + sumBT(root.right);
  }
}
