package dsalgo.learning.karumanchibook.linkedlist.problems;

/* Problem Description: check if given list is null terminated or ends in a cycle */
public class Problem_2 {
  public static boolean hasLoop(Node head) {
    // code here
    Node fastNode, slowNode;
    fastNode = slowNode = head;

    while (fastNode != null || fastNode.next != null) {
      fastNode = fastNode.next;
      if (fastNode == null) return false;
      fastNode = fastNode.next;
      slowNode = slowNode.next;

      if (fastNode == slowNode) return true;
    }
    return false;
  }
}
