package dsalgo.learning.karumanchibook.linkedlist.problems;

/* Problem Description: Insert a node in sorted linked list */
public class Problem_5 {

  /*
   * Case 1: new node at start
   * Case 2: new node in middle
   * Case 3: new node in last
   * */
  public Node insertNodeInSortedLinkedList(Node<Integer> head, Node<Integer> newNode) {

    // new node is to be inserted in the start of linked list
    if (head == null || head.data > newNode.data) {
      newNode.next = head;
      return newNode;
    }

    // new node is to be inserted in middle of list
    Node<Integer> current = head.next;
    Node<Integer> previous = head;
    while (current != null) {
      if (current.data > newNode.data) break;

      current = current.next;
      previous = previous.next;
    }

    // takes care of both case 2 and 3
    previous.next = newNode;
    return head;
  }
}
