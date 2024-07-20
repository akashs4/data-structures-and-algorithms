package dsalgo.learning.coursera.algorithms.part1.week2.stack.impl;

import dsalgo.learning.coursera.algorithms.part1.week2.stack.StackOfStrings;

public class FixedArrayStackOfStringsImpl implements StackOfStrings {
    private String[] stackArr;
    private int size;

    public FixedArrayStackOfStringsImpl(int n) {
        this.stackArr = new String[n];
    }

    public static void main(String[] args) {
        FixedArrayStackOfStringsImpl stack = new FixedArrayStackOfStringsImpl(5);
        stack.push("My");
        stack.push("My2");
        stack.push("My3");
        stack.push("My4");
        String item = stack.pop();

        stack.printCurrentStack();
        System.out.println("Popped item: " + item);
    }

    @Override
    public void push(String s) {
        this.stackArr[size++] = s;
    }

    @Override
    public String pop() {
        String item = this.stackArr[--size];
        this.stackArr[size] = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void printCurrentStack() {
        for (int i = 0; i < stackArr.length; i++)
            System.out.println(stackArr[i] + ",");
    }
}
