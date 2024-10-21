package dsalgo.learning.clrs.ch10.linkedlist.implementations;

public class SentinelDoubleLinkedList<T> {
    private Node<T> sentinel;
    private int size;

    public SentinelDoubleLinkedList() {
        this.sentinel = new Node<>();
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
        this.size = 0;
    }

    /**
     * Inserts the given element at the front of linked list
     */
    public void insert(T key) {
        Node<T> newNode = new Node<>(key);
        newNode.next = this.sentinel.next;
        newNode.prev = this.sentinel;

        this.sentinel.next.prev = newNode;
        this.sentinel.next = newNode;
        this.size++;
    }

    /**
     * Removes the given element from list.
     * Reference to the node which will be removed is provided as parameter.
     */
    public void delete(Node<T> node) {
        if (node == null)
            throw new IllegalArgumentException("Node to be removed can not be null");
        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.size--;
    }

    public T search(T key) {
        Node<T> temp = this.sentinel.next;
        while (temp != this.sentinel && temp.item != key)
            temp = temp.next;
        return temp.item;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    private static class Node<T> {
        Node<T> prev;
        T item;
        Node<T> next;

        public Node(T item) {
            this.item = item;
        }

        public Node() {
        }
    }
}
