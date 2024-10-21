package dsalgo.learning.coursera.algorithms.part1.module4.stack.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl<T> implements Iterable<T> {
    private T[] stack;
    private int size;
    private static final int INITIAL_SIZE = 8;

    public StackImpl() {
        this.stack = (T[]) new Object[INITIAL_SIZE];
        this.size = 0;
    }

    public StackImpl(int capacity) {
        this.stack = (T[]) new Object[capacity];
        this.size = 0;
    }

    public StackImpl(T[] items) {
        this.stack = (T[]) new Object[Math.max(items.length, INITIAL_SIZE)];
        System.arraycopy(items, 0, stack, 0, items.length);
        size = items.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T item) {
        if (size == stack.length)
            resize(stack.length * 2);
        stack[size++] = item;
    }

    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow - cannot pop from empty stack");
        T item = stack[--size];
        stack[size] = null;

        if (size > 0 && size == stack.length / 4)
            resize(stack.length / 2);

        return item;
    }

    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Stack is empty");
        return stack[size - 1];
    }

    private void resize(int capacity) {
        if (capacity < INITIAL_SIZE)
            capacity = INITIAL_SIZE;
        T[] copy = (T[]) new Object[capacity];
        System.arraycopy(stack, 0, copy, 0, size);
        stack = copy;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int current = size;

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return current > 0;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return stack[--current];
        }
    }
}
