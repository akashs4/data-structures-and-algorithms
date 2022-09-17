package dsalgo.learning.geeksforgeeks.binarytree;

import java.util.ArrayList;
import java.util.List;

/* Problem Description: Print left view of binary tree */
public class Easy_2_LeftView {

  private int min = 0;

  public ArrayList<Integer> leftView(Node root) {
    ArrayList<Integer> result = new ArrayList<>();

    helper(root, 1, result);

    return result;
  }

  private void helper(Node root, int value, List<Integer> result) {
    if (root == null) return;

    if (value > min) {
      result.add(root.data);
      min++;
    }

    helper(root.left, value + 1, result);
    helper(root.right, value + 1, result);
  }
}