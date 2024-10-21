package dsalgo.learning.clrs.ch10.array.implementations;

import java.util.NoSuchElementException;

public class ArrayDequeueImpl<T> {
    private T[] dequeue;
    private int head;
    private int tail;
    private static final int INITIAL_SIZE = 8;

    public ArrayDequeueImpl(int capacity) {
        this.dequeue = (T[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
    }

    public ArrayDequeueImpl() {
        this.dequeue = (T[]) new Object[INITIAL_SIZE];
        this.head = 0;
        this.tail = 0;
    }

    public void addFirst(T item) {

    }

    public void addLast(T item) {
        if (!isEmpty() && head == tail)
            resize(dequeue.length * 2);
        dequeue[tail] = item;
        if (tail == dequeue.length - 1)
            tail = 0;
        else tail++;
    }

    public T removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Dequeue underflow");

        T item = dequeue[head];
        dequeue[head] = null;
        if (head == dequeue.length - 1)
            head = 0;
        else head++;

        if (!isEmpty() && size() == dequeue.length / 4)
            resize(dequeue.length / 2);

        return item;
    }

    public T removeLast() {
        return null;
    }

    public int size() {
        if (tail == head && head == 0)
            return 0;
        return tail > head ? (tail - head) : (dequeue.length + tail - head);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize(int capacity) {

    }
}
/**
 * h,t
 * 0 1 2 3 4 5 6 7 8 9
 *
 * */