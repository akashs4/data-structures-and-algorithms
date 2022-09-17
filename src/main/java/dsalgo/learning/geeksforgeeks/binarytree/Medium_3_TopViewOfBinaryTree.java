package dsalgo.learning.geeksforgeeks.binarytree;

import java.util.*;

/* Problem Description: Top view of binary tree */
public class Medium_3_TopViewOfBinaryTree {

  public ArrayList<Integer> topView(Node node) {
    ArrayList<Integer> result = new ArrayList<>();
    Map<Integer, Integer> map = new TreeMap<>();

    Queue<AdvancedNode> queue = new LinkedList<>();
    queue.offer(new AdvancedNode(node, 0));

    while (!queue.isEmpty()) {
      AdvancedNode temp = queue.poll();
      Node tempNode = temp.getNode();
      int lvl = temp.getLvl();

      if (!map.containsKey(lvl)) {
        map.put(lvl, tempNode.data);
      }

      if (tempNode.left != null) queue.offer(new AdvancedNode(tempNode.left, lvl - 1));
      if (tempNode.right != null) queue.offer(new AdvancedNode(tempNode.right, lvl + 1));
    }

    map.values().stream().forEach(result::add);

    return result;
  }

  class AdvancedNode {
    private int lvl;
    private Node node;

    public AdvancedNode(Node node, int lvl) {
      this.node = node;
      this.lvl = lvl;
    }

    public int getLvl() {
      return lvl;
    }

    public void setLvl(int lvl) {
      this.lvl = lvl;
    }

    public Node getNode() {
      return node;
    }

    public void setNode(Node node) {
      this.node = node;
    }
  }
}
