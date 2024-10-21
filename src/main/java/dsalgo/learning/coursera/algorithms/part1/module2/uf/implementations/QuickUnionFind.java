package dsalgo.learning.coursera.algorithms.part1.module2.uf.implementations;

public class QuickUnionFind implements UF {
    private final int[] id;
    private int count;

    public QuickUnionFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    @Override
    public void union(int p, int q) {
        validate(p);
        validate(q);

        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ)
            return;

        id[p] = rootQ;
        count--;
    }

    @Override
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);

        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        return count;
    }

    public void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("Index is not between 0 and " + (n - 1));
        }
    }
}
