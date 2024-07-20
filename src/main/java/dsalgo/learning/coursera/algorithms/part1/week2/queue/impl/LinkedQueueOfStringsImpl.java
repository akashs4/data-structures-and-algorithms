package dsalgo.learning.coursera.algorithms.part1.week2.queue.impl;

import dsalgo.learning.coursera.algorithms.part1.week2.queue.QueueOfStrings;

/**
 * Key thing is to add items along the direction of pointers from linked list next pointers
 * and pop the items in the same direction too
 * What are the possible cases then???
 */
public class LinkedQueueOfStringsImpl implements QueueOfStrings {
    private Node first;
    private Node last;

    public LinkedQueueOfStringsImpl() {
    }

    @Override
    public void enqueue(String s) {
        Node oldLast = last;
        last = new Node();
        last.item = s;
        last.next = null; // by default this is already done
        if (isEmpty())
            first = last;
        else oldLast.next = last;
    }

    @Override
    public String dequeue() {
        if (first == null)
            return null;
        String item = first.item;
        first = first.next;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    private class Node {
        Node next;
        String item;
    }
}
