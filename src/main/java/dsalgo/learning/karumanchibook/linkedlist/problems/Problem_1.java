package dsalgo.learning.karumanchibook.linkedlist.problems;

/* Problem Description: Find nth node from end of linked list */
public class Problem_1 {
  public Node findNthNodeFromEnd(Node head, int n) {

    Node firstNode, secondNode;
    firstNode = secondNode = head;
    int count = 0;
    while (count++ < n) {
      if(firstNode!=null)
        firstNode = firstNode.next;
      else
        return null;// return null in scenarios like asking 6th from last in list of size less than 6
    }

    while (firstNode != null) {
      firstNode = firstNode.next;
      secondNode = secondNode.next;
    }

    return secondNode;
  }
}