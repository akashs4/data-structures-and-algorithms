package dsalgo.learning.coursera.algorithms.part1.module4.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBagImpl<T> implements Iterable<T> {
    private Node<T> first;
    private int size;

    public LinkedBagImpl() {
        this.first = null;
        this.size = 0;
    }

    public void add(T item) {
        Node<T> oldFirst = first;
        first = new Node<T>();
        first.item = item;
        first.next = oldFirst;
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(first);
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = first;

        public LinkedListIterator(Node<T> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException("Bag is empty");
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;
    }
}
