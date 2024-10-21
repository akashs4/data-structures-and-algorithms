package dsalgo.learning.leetcode.array.medium;

public class Test {

    public static void main(String[] args) {
        Test obj = new Test();
        System.out.println("Starting main method with test object created");

        obj = null;
        System.gc();
    }

    public void finalize() {
        System.out.println("About to destroy Test object");
    }
}
