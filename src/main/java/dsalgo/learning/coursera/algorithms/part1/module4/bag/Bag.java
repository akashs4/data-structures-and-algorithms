package dsalgo.learning.coursera.algorithms.part1.module4.bag;

public interface Bag<T> {
    void add(T item);

    int size();

    Iterable<T> iterator();
}
