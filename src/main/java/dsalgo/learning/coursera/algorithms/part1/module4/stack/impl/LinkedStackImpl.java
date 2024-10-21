package dsalgo.learning.coursera.algorithms.part1.module4.stack.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStackImpl<T> implements Iterable<T> {
    private Node<T> first;
    private int size;

    public LinkedStackImpl() {
        this.first = null;
        this.size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(first);
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current;

        public LinkedListIterator(Node<T> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException("No more elements in stack");
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public void push(T item) {
        Node<T> oldFirst = first;
        first = new Node<T>();
        first.item = item;
        first.next = oldFirst;
        this.size++;
    }

    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        T item = first.item;
        first = first.next;
        this.size--;
        return item;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.size;
    }

    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty");
        return first.item;
    }

    private static class Node<T> {
        T item;
        Node<T> next;
    }
}
