package dsalgo.learning.geeksforgeeks.binarytree;

import java.util.ArrayList;

public class Basic_2_PreOrderTraversal {
  public static ArrayList<Integer> preorder(Node root) {
    ArrayList<Integer> result = new ArrayList<>();
    helper(root, result);

    return result;
  }

  private static void helper(Node node, ArrayList<Integer> result) {
    if (node == null) return;

    result.add(node.data);
    helper(node.left, result);
    helper(node.right, result);
  }
}
