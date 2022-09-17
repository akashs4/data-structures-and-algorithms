package dsalgo.learning.geeksforgeeks.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* Problem Description: Level order traversal */
public class Easy_6_LevelOrderTraversal {

  static ArrayList<Integer> levelOrder(Node node) {
    ArrayList<Integer> result = new ArrayList<>();

    if (node == null) return result;

    Queue<Node> queue = new LinkedList<>();
    queue.offer(node);

    while (!queue.isEmpty()) {
      Node temp = queue.poll();
      result.add(temp.data);
      if (temp.left != null) queue.offer(temp.left);
      if (temp.right != null) queue.offer(temp.right);
    }

    return result;
  }
}
