package dsalgo.learning.clrs.ch02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeSortTest {

    @Test
    public void sortUnsortedEvenLengthArrayTest() {
        int[] arr = {5, 2, 4, 6, 1, 3};
        MergeSort.sort(arr, 0, arr.length - 1);

        int[] expectedArr = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void sortUnsortedOddLengthArrayTest() {
        int[] arr = {5, 2, 4, 6, 1};
        MergeSort.sort(arr, 0, arr.length - 1);

        int[] expectedArr = {1, 2, 4, 5, 6};
        Assertions.assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortOnSortedArray() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        MergeSort.sort(arr, 0, arr.length - 1);

        int[] expectedArr = {1, 2, 3, 4, 5, 6};
        Assertions.assertArrayEquals(expectedArr, arr);
    }
}
