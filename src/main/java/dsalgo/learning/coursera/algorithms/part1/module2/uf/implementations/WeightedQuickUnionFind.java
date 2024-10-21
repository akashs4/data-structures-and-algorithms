package dsalgo.learning.coursera.algorithms.part1.module2.uf.implementations;

public class WeightedQuickUnionFind implements UF {
    private int[] id;
    private int[] size;
    private int count;

    public WeightedQuickUnionFind(int N) {
        this.count = N;
        id = new int[N];
        size = new int[N];
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

        if (size[rootP] >= size[rootQ]) {
            id[rootQ] = rootP;
//            id[rootQ] = id[rootP];
            size[rootP] += size[rootQ];
        } else {
            id[rootP] = rootQ;
//            id[rootP] = id[rootQ];
            size[rootQ] += size[rootP];
        }
        count--;
    }

    @Override
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        validate(p);
        while (p != id[p])
            p = id[p];
        return p;
    }

    @Override
    public int count() {
        return count;
    }

    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("p should be between 0 and " + (n - 1));
        }
    }
}
