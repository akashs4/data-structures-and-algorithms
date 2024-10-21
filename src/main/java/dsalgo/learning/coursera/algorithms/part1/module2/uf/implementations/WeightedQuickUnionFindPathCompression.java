package dsalgo.learning.coursera.algorithms.part1.module2.uf.implementations;

public class WeightedQuickUnionFindPathCompression implements UF {
    private int[] id;
    private short[] size;
    private int count;

    public WeightedQuickUnionFindPathCompression(int N) {
        this.count = N;
        this.size = new short[N];
        this.id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int maxHeight() {
        return 0;
    }

    @Override
    public void union(int p, int q) {
        validate(p);
        validate(q);

        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

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

        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    @Override
    public int find(int p) {
        validate(p);
        int root = p;// stored initial value of p

        while (root != id[root]) {
            root = id[root];
            id[root] = id[id[root]]; // path compression, point to grand parent, if only immediate parent, nothing happens
        }

//        int tmp, root = i;
//        can also have an extra loop to link every child to root
//        while (p != root) {
//            tmp = id[p];
//            id[p] = root;
//            p = tmp;
//        }

        return root;
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
