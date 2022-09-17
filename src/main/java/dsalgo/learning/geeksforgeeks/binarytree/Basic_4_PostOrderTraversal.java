package dsalgo.learning.geeksforgeeks.binarytree;

import java.util.ArrayList;

public class Basic_4_PostOrderTraversal {
  public ArrayList<Integer> postOrder(Node root) {
    ArrayList<Integer> result = new ArrayList<>();
    helper(root, result);
    return result;
  }

  private void helper(Node node, ArrayList<Integer> result) {
    if (node == null) return;

    helper(node.left, result);
    helper(node.right, result);
    result.add(node.data);
  }
}
