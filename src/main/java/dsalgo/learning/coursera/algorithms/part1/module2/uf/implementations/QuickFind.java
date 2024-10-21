package dsalgo.learning.coursera.algorithms.part1.module2.uf.implementations;

public class QuickFind implements UF {
    private final int[] arr;
    private int count;

    public QuickFind(int N) {
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = i;
        count = N;
    }

    @Override
    public void union(int p, int q) {
        validate(p);
        validate(q);

        int target = arr[q];
        int initial = arr[p];

        if (target == initial)
            return;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == initial) {
                arr[i] = target;
            }
        }

        // update number of connected components
        count--;
    }

    @Override
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return arr[p] == arr[q];
    }

    @Override
    public int find(int p) {
        validate(p);
        return arr[p];
    }

    @Override
    public int count() {
        return count;
    }

    private void validate(int p) {
        int n = arr.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index is not between 0 and " + (n - 1));
        }
    }
}
