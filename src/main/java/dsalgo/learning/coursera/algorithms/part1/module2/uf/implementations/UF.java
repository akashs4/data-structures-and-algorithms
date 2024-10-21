package dsalgo.learning.coursera.algorithms.part1.module2.uf.implementations;

public interface UF {
    void union(int p, int q);
    boolean connected(int p, int q);
    int find(int p);
    int count();
}
