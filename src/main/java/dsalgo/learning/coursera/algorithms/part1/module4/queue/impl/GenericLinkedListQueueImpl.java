package dsalgo.learning.coursera.algorithms.part1.module4.queue.impl;

import java.util.Stack;

public class GenericLinkedListQueueImpl<T> {
    private class Node {
        T item;
        Node next;
    }

    private Node first;
    private Node last;


    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T dequeue() {
        if (isEmpty())
            return null;

        T item = first.item;
        first = first.next;
        return item;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        System.out.println(stack.capacity());
        System.out.println(stack.size());
    }

}
