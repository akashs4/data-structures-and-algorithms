package dsalgo.learning.coursera.algorithms.part1.module5;

public class Shell {
    private Shell() {
    }

    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;

        while (h / 3 < N)
            h = (3 * h) + 1;

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j - h]))
                        exch(a, j, j - h);
                }
                h = h / 3;
            }
        }
    }

    private boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
