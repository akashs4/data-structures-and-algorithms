package dsalgo.learning.karumanchibook.linkedlist.problems;

// Problem Description : Reverse a single linked list
// TODO: Solve using recursion as well
public class Problem_6 {

  public static Node reverse(Node head) {
    if (head == null || head.next == null) return head;

    Node newHead = null;
    Node current = head;
    Node next = head.next;

    while (current != null) {
      current.next = newHead;
      newHead = current;
      current = next;
      if (next != null) next = next.next;
    }

    return newHead;
  }

  public static void main(String[] args) {
    Node<Integer> head = new Node<>(1);
    Node<Integer> temp = head;
    temp.next = new Node<>(3);
    temp = temp.next;
    temp.next = new Node<>(5);
    temp = temp.next;
    temp.next = new Node<>(7);
    temp = temp.next;
    temp.next = new Node<>(9);

    Node current = head;
    while (current != null) {
      System.out.print(current.data + ", ");
      current = current.next;
    }

    System.out.println();

    Node reverseHead = reverse(head);
    current = reverseHead;
    while (current != null) {
      System.out.print(current.data + ", ");
      current = current.next;
    }
  }
}
