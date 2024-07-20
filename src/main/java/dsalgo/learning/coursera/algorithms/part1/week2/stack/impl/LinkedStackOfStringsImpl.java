package dsalgo.learning.coursera.algorithms.part1.week2.stack.impl;


import dsalgo.learning.coursera.algorithms.part1.week2.stack.StackOfStrings;

public class LinkedStackOfStringsImpl implements StackOfStrings {

    private Node first = null;
    private int size = 0;

    public LinkedStackOfStringsImpl() {

    }

    @Override
    public void push(String s) {
        Node oldFirst = first;
        first = new Node();
        first.item = s;
        first.next = oldFirst;
        size++;
    }

    @Override
    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    private class Node {
        String item;
        Node next;
    }
}
