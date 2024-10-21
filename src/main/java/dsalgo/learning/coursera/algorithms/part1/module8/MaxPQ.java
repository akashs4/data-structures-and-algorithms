package dsalgo.learning.coursera.algorithms.part1.module8;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * We start inserting the elements in array from index 1.
 * This is done for simplicity
 */
public class MaxPQ<Key extends Comparable<Key>> implements Iterable<Key> {
    private Key[] pq;
    private int N; // represents the number of elements in heap
    private final int INITIAL_CAPACITY = 8;

    public MaxPQ(int capacity) {
        this.pq = (Key[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    public MaxPQ() {
        this.pq = (Key[]) new Comparable[INITIAL_CAPACITY];
        this.N = 0;
    }

    public Key max() {
        if (isEmpty())
            throw new NoSuchElementException("Priority Queue is empty");
        return pq[1];
    }

    public Key delMax() {
        if (isEmpty())
            throw new NoSuchElementException("Priority Queue is empty");
        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[this.N + 1] = null;


        /**
         * 0 1 2 3 4 5 6 7
         * - 4 9 N N N N N
         * Checking against (pq.length-1)/4 because values are starting from 1 and from above,
         * when N=2, and length=8, array is not one-quarter full
         */
        if (N > 0 && N == ((pq.length - 1) / 4))
            resize(pq.length / 2);
        return max;
    }

    /**
     * @return the numnber of elements in Priority Queue
     */
    public int size() {
        return this.N;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public void insert(Key key) {
        if (N == this.pq.length - 1)
            resize(2 * pq.length);
        this.pq[++N] = key;
        swim(N);
        // assertion for checking if it is max Heap
    }

    /**
     * Used to float the value to correct index, so that heap maintains
     * Difference between heapify(sink) and swim:
     * - In max Heapify, we have a parent violating heap property, so we move down the tree to find suitable place
     * - In swim, we have a child violating heap property, so we move up the tree to find suitable place
     *
     * @param k is child index
     */
    private void swim(int k) {
        validate(k);
        while (k > 1 && less(k / 2, k)) { // index is > root and parent has less value than current child
            exch(k / 2, k); // exchange parent value with child value
            k = k / 2; // update index to parent, to check the same thing again for parent index
        }
    }

    private void validate(int k) {
        if (k <= 0 || k > N)
            throw new IllegalArgumentException("Index can be from 1 to " + N);
    }

    /**
     * Similar to max heapify
     *
     * @param k is parent Index
     */
    private void sink(int k) {
        validate(k);
        while (2 * k <= N) {   // while child index is less than heap size
            int j = 2 * k; // calculate left index
            if (j < N && less(j, j + 1)) // compare and find biggest child
                j++;
            if (!less(k, j)) // if parent is not less than biggest child, then stop
                break;
            exch(k, j); // if not, exchange value at parent with biggest child
            k = j; // repeat same process at biggest child index
        }
    }

    private void resize(int capacity) {
        Key[] copy = (Key[]) new Comparable[capacity];
        System.arraycopy(pq, 0, copy, 0, N);
        this.pq = copy;
    }

    private boolean less(int index, int otherIndex) {
        return pq[index].compareTo(pq[otherIndex]) < 0;
    }

    private void exch(int index, int otherIndex) {
        Key temp = pq[index];
        pq[index] = pq[otherIndex];
        pq[otherIndex] = temp;
    }

    @Override
    public Iterator<Key> iterator() {
        return new MaxPQIterator();
    }

    private class MaxPQIterator implements Iterator<Key> {
        private MaxPQ<Key> copy;

        private MaxPQIterator() {
            this.copy = new MaxPQ<>(size());
            for (int i = 1; i <= N; i++)
                copy.insert(pq[i]);
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not allowed");
        }

        @Override
        public Key next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return copy.delMax();
        }
    }
}
