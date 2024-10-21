package dsalgo.learning.clrs.ch10.linkedlist.implementations;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueUsingLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public QueueUsingLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Two scenarios: enqueue in empty queue or non-empty queue
     * For empty queue, will have to take care of both head and tail
     * For non-empty queue, will have to just worry about tail
     */
    public void enqueue(T item) {
        Node<T> newNode = new Node<>();
        newNode.item = item;
        newNode.next = null;
        if (isEmpty()) head = newNode;
        else tail.next = newNode;
        tail = newNode;
        size++;
    }

    /**
     * Two possible scenarios
     * 1. After dequeue, queue is non-empty
     * 2. After dequeue, queue is empty
     * If queue is empty, consider updating both head and tail
     * If queue is non-empty after dequeue, have to worry only about head
     */
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        T item = head.item;
        head = head.next;
        size--;
        if (isEmpty()) tail = null;
        return item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<T> {
        private Node<T> next;
        private T item;
    }


    @Override
    public Iterator<T> iterator() {
        Node<T> temp = head;
        return new QueueIterator<>(temp);
    }

    // iterates in FIFO manner
    private static class QueueIterator<T> implements Iterator<T> {
        private Node<T> current;

        public QueueIterator(Node<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
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
