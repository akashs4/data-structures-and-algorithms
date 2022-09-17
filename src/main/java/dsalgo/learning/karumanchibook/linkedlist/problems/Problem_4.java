package dsalgo.learning.karumanchibook.linkedlist.problems;

/* Problem Description: find length of cycle in given list, 0 if cycle is not present */
public class Problem_4 {
  public int findLengthOfCycle(Node head) {
    int cycleLength = 0;

    Node fastNode, slowNode;
    boolean hasCycle = false;

    fastNode = slowNode = head;

    while (fastNode != null && fastNode.next != null) {
      fastNode = fastNode.next.next;
      slowNode = slowNode.next;

      if (fastNode == slowNode) {
        hasCycle = true;
        break;
      }
    }

    if (!hasCycle) return 0;

    while (slowNode.next != fastNode) {
      slowNode = slowNode.next;
      cycleLength++;
    }

    return cycleLength;
  }
}
