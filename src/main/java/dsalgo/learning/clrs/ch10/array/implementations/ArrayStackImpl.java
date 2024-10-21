package dsalgo.learning.clrs.ch10.array.implementations;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStackImpl<T> implements Iterable<T> {
    private T[] stack;
    private int N;
    private static final int INITIAL_SIZE = 8;

    public ArrayStackImpl() {
        this.stack = (T[]) new Object[INITIAL_SIZE];
        this.N = 0;
    }

    public ArrayStackImpl(int capacity) {
        this.stack = (T[]) new Object[capacity];
        this.N = 0;
    }

    public ArrayStackImpl(T[] elements) {
        int elementsSize = elements.length;
        this.stack = (T[]) new Object[Math.max(INITIAL_SIZE, elementsSize * 2)];
        for (T element : elements) this.stack[N++] = element;
    }

    public void push(T item) {
        if (N == stack.length)
            resize(stack.length * 2);
        stack[N++] = item;
    }

    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        T item = stack[--N];
        stack[N] = null;

        if (N > 0 && N == stack.length / 4)
            resize(stack.length / 2);

        return item;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int capacity) {
        if (capacity < INITIAL_SIZE)
            capacity = INITIAL_SIZE;
        T[] copy = (T[]) new Object[capacity];
        System.arraycopy(stack, 0, copy, 0, N);
        this.stack = copy;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayStackIterator(N);
    }

    private class ArrayStackIterator implements Iterator<T> {
        private int current;

        public ArrayStackIterator(int current) {
            this.current = current;
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

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation not supported");
        }
    }
}
