package dsalgo.learning.coursera.algorithms.part1.module4.stack.impl;

import dsalgo.learning.coursera.algorithms.part1.module4.stack.StackOfStrings;

public class ArrayStackOfStringsImpl implements StackOfStrings {
    private final int MIN_SIZE = 8;
    private String[] stack;
    private int size;

    public ArrayStackOfStringsImpl() {
        stack = new String[MIN_SIZE];
        this.size = 0;
    }

    @Override
    public void push(String s) {
        if (this.size == this.stack.length)
            resize(2 * this.stack.length);
        this.stack[this.size++] = s;
    }

    /**
     * Double the size when array becomes full
     * Half the size when array is quarter full
     */
    private void resize(int capacity) {
        String[] copy = new String[capacity];
        System.arraycopy(this.stack, 0, copy, 0, this.size);
        this.stack = copy;
    }

    @Override
    public String pop() {
        if (this.size == 0)
            throw new RuntimeException("Stack is empty");

        String item = this.stack[--this.size];
        this.stack[this.size] = null;

        if (this.size > 0 && this.size == this.stack.length / 4)
            resize(this.stack.length / 2);
        return item;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }
}
