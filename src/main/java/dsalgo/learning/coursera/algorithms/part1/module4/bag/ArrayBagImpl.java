package dsalgo.learning.coursera.algorithms.part1.module4.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayBagImpl<T> implements Iterable<T> {

    private final int INITIAL_SIZE = 8;
    private T[] items;
    private int size;

    public ArrayBagImpl() {
        this.items = (T[]) new Object[INITIAL_SIZE];
        this.size = 0;
    }

    public void add(T item) {
        if(this.size == this.items.length)
            resize(this.items.length * 2);

        this.items[this.size++] = item;
    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        System.arraycopy(items, 0, copy, 0, this.items.length);
        this.items = copy;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int index = size;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException("Bag is empty");

            return items[--index];
        }
    }
}
