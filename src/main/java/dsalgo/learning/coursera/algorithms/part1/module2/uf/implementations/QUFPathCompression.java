package dsalgo.learning.coursera.algorithms.part1.module2.uf.implementations;

// Union Find that uses height information in union information instead of size of components
public class QUFPathCompression implements UF {
    private int[] id;
    private byte[] height;
    private int count;
    private int maxHeight;

    public QUFPathCompression(int N) {
        this.height = new byte[N];
        this.id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        this.count = N;
    }

    public int[] getId() {
        return id;
    }

    /**
     * Merges the set containing element {@code p} with set containing element {@code q}
     *
     * @param p and q are elements for union operation
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     **/
    @Override
    public void union(int p, int q) {
        validate(p);
        validate(q);

        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ)
            return;

        if (height[rootP] > height[rootQ])
            id[rootQ] = rootP;
        else if (height[rootP] < height[rootQ])
            id[rootP] = rootQ;
        else {
            id[rootP] = rootQ;
            height[rootQ]++;
            if (height[rootQ] > maxHeight)
                maxHeight = height[rootQ];
        }
        count--;
    }

    public void printHeight() {
        for (int i = 0; i < height.length; i++)
            System.out.print("height[" + i + "]= " + height[i] + ", ");
    }

    public void printConnectedComponent() {
        for (int i = 0; i < id.length; i++)
            System.out.print("id[" + i + "]= " + id[i] + ", ");
    }

    public int getMaxHeight() {
        return maxHeight;
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
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        return count;
    }

    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n)
            throw new IllegalArgumentException("index " + p + " is not between " + 0 + " and " + n);
    }
}
