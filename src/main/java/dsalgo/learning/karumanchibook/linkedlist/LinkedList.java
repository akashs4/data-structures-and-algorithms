package dsalgo.learning.karumanchibook.linkedlist;

import dsalgo.learning.karumanchibook.linkedlist.problems.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
  private static final int ZERO = 0;
  private Node<T> head;
  private int size = ZERO;

  public LinkedList() {
    this.head = null;
  }

  public Node getHead(){
    return head;
  }

  public int size() {
    return size;
  }

  public void addFirst(T value) {
    addAt(value, 1);
  }

  public void addLast(T value) {
    addAt(value, size + 1);
  }

  public void addAt(T value, int position) {
    Node dummyNode = new Node<>();
    Node newNode = new Node(value);
    Node temp = dummyNode;

    if (head == null) {
      this.head = newNode;
      return;
    }

    dummyNode.next = head;
    int current = 0;

    while (temp != null && current++ < position - 1) {
      temp = temp.next;
    }

    newNode.next = temp.next;
    temp.next = newNode;

    this.head = dummyNode.next;
    size++;
  }

  public void deleteFirst() {
    deleteAt(1);
  }

  public void deleteLast() {
    deleteAt(size());
  }

  /* @Param:position represents position of node in list, position of first node is 1 */
  public void deleteAt(int position) {
    if (head == null) return;

    Node dummyNode = new Node();
    Node temp = dummyNode;
    dummyNode.next = head;
    int current = 0;

    while (temp != null && current++ < position - 1) temp = temp.next;

    Node nextNode = temp.next.next;
    temp.next = nextNode;

    this.head = dummyNode.next;
  }

  @Override
  public Iterator iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements Iterator<T> {
    private Node currentNode = head;

    @Override
    public boolean hasNext() {
      return currentNode != null;
    }

    @Override
    public T next() {
      if (!hasNext()) throw new NoSuchElementException("No elements anymore");

      T data = (T) currentNode.data;
      currentNode = currentNode.next;
      return data;
    }
  }

  // delete node -> variation same as addition
  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addFirst(1);
    linkedList.addFirst(2);
    linkedList.addLast(3);
    linkedList.addFirst(4);

    Iterator iter = linkedList.iterator();
    System.out.println("size: " + linkedList.size());

    while (iter.hasNext()) {
      System.out.print(iter.next() + " ");
    }
  }
}
