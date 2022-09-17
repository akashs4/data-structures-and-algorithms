package dsalgo.learning.karumanchibook.linkedlist.problems;

public class Node<T> {
  public T data;
  public Node next;

  public Node() {
    this.data = null;
    this.next = null;
  }

  public Node(T data) {
    this.data = data;
    this.next = null;
  }
}