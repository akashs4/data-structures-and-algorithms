package dsalgo.learning.clrs.ch10.array.implementations;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueueImpl<T> implements Iterable<T> {
    private T[] queue;
    private int tail; // tail points to the empty position, where insertion will happen for new item
    private int head; // head points to first element
    private static final int INITIAL_SIZE = 8;

    public ArrayQueueImpl() {
        this.queue = (T[]) new Object[INITIAL_SIZE];
        this.head = 0;
        this.tail = 0;
    }

    public ArrayQueueImpl(int N) {
        this.queue = (T[]) new Object[N];
        this.head = 0;
        this.tail = 0;
    }

    // handle overflow
    public void enqueue(T item) {
        /**
         * check for overflow
         * (tail + 1) % queue.length == head -> queue is full
         * */

        if (!isEmpty() && tail == head)
            resize(queue.length * 2);

        queue[tail] = item;
        if (tail == queue.length - 1) tail = 0;
        else tail++;
    }

    // handle underflow
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        T item = queue[head];
        queue[head] = null;
        if (head == queue.length - 1) head = 0;
        else head++;

        if (size() == queue.length / 4)
            resize(queue.length / 2);

        return item;
    }

    public int size() {
        /**
         * if tail < head, value becomes less than queue.length and we get the size
         *      -when tail is less, difference is essentially the empty part, subtract empty part from length, we get size
         * if tail > head, value becomes more than queue.length and we get the size
         *      -difference gives the size in this case, adding and taking mod, is just to cover both cases
         * */

        if (head == tail && head == 0)
            return 0;
        return (tail > head) ? (tail - head) : (queue.length + tail - head);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < size(); i++)
            copy[i] = queue[(head + i) % queue.length]; // index always remain bounded by modulus operation
        head = 0;
        tail = size();
        queue = copy;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayQueueIterator(head);
    }

    private class ArrayQueueIterator implements Iterator<T> {
        private int index;
        private int i;

        public ArrayQueueIterator(int index) {
            this.index = index;
            this.i = 0;
        }

        @Override
        public boolean hasNext() {
            return i < size();
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return queue[(index + i) % queue.length];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
