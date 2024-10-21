package dsalgo.learning.coursera.algorithms.part1.module4.queue.impl;

import dsalgo.learning.coursera.algorithms.part1.module4.queue.QueueOfStrings;

public class ArrayQueueOfStringsImpl implements QueueOfStrings {
    private final int INITIAL_SIZE = 8;
    private String[] queue;
    private int size;

    public ArrayQueueOfStringsImpl() {
        this.queue = new String[INITIAL_SIZE];
        this.size = 0;
    }

    @Override
    public void enqueue(String s) {

    }

    @Override
    public String dequeue() {
        return "";
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
