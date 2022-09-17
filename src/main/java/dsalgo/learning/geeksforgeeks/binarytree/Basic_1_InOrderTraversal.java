package dsalgo.learning.geeksforgeeks.binarytree;

import java.util.ArrayList;

public class Basic_1_InOrderTraversal {

  public ArrayList<Integer> inOrder(Node root) {
    ArrayList<Integer> result = new ArrayList<>();

    helper(root, result);

    return result;
  }

  private void helper(Node node, ArrayList<Integer> result) {
      if(node == null)
          return;

      helper(node.left, result);
      result.add(node.data);
      helper(node.right, result);
  }
}
