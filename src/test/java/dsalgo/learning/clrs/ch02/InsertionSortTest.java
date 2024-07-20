package dsalgo.learning.clrs.ch02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertionSortTest {

    @Test
    public void sortUnsortedArrayTest() {
        InsertionSort insertionSort = new InsertionSort();

        int[] arr = {5, 2, 4, 6, 1, 3};
        insertionSort.sort(arr);

        int[] expectedArr = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortOnSortedArray() {
        InsertionSort insertionSort = new InsertionSort();

        int[] arr = {1, 2, 3, 4, 5, 6};
        insertionSort.sort(arr);

        int[] expectedArr = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(expectedArr, arr);
    }
}
