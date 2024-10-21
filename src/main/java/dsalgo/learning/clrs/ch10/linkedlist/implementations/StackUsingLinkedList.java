package dsalgo.learning.clrs.ch10.linkedlist.implementations;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackUsingLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public StackUsingLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>();
        newNode.item = item;
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        T item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        return head.item;
    }

    @Override
    public Iterator<T> iterator() {
        Node<T> temp = head;
        return new StackIterator<>(temp);
    }

    private static class Node<T> {
        Node<T> next;
        T item;
    }

    private static class StackIterator<T> implements Iterator<T> {
        private Node<T> current;

        public StackIterator(Node<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }
}
