package dsalgo.learning.geeksforgeeks.binarytree;

import java.util.ArrayList;
import java.util.Stack;

/* Problem Description: Boundary Traversal of binary tree */
public class Medium_1_BoundaryTraversal {
  public ArrayList<Integer> boundary(Node node) {
    ArrayList<Integer> result = new ArrayList<>();

    if (node == null) return result;

    Stack<Integer> rightNodes = new Stack<>();

    result.add(node.data);
    addLeftNodes(node.left, result);
    addLeafNodes(node.left, result);
    addLeafNodes(node.right, result);
    addRightNodes(node.right, rightNodes);

    while (!rightNodes.isEmpty()) {
      int num = rightNodes.pop();
      result.add(num);
    }

    return result;
  }

  private void addLeafNodes(Node root, ArrayList<Integer> leafNodes) {
    if (root == null) return;

    if (root.left == null && root.right == null) {
      leafNodes.add(root.data);
      return;
    }

    addLeafNodes(root.left, leafNodes);
    addLeafNodes(root.right, leafNodes);
  }

  private void addRightNodes(Node root, Stack<Integer> rightNodes) {
    if (root == null) return;

    if (root.left == null && root.right == null) return;

    rightNodes.add(root.data);
    if (root.right != null) addRightNodes(root.right, rightNodes);
    else if (root.left != null) addRightNodes(root.left, rightNodes);
  }

  private void addLeftNodes(Node root, ArrayList<Integer> leftNodes) {
    if (root == null) return;

    if (root.left == null && root.right == null) {
      return;
    }

    leftNodes.add(root.data);
    if (root.left != null) addLeftNodes(root.left, leftNodes);
    else if (root.right != null) addLeftNodes(root.right, leftNodes);
  }
}
