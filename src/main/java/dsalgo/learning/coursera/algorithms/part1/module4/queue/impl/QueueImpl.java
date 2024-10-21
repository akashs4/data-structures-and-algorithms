package dsalgo.learning.coursera.algorithms.part1.module4.queue.impl;

import java.util.Iterator;

public class QueueImpl<T> implements Iterable<T> {
    private Node first;
    private Node last;

    public QueueImpl() {

    }

    public void enqueue(T item) {

    }

    public T dequeue() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    private class Node {
        T value;
        Node next;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class LinkedListIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
