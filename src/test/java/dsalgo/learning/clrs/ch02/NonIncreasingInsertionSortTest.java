package dsalgo.learning.clrs.ch02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NonIncreasingInsertionSortTest {

    @Test
    public void testNonIncreasingSort() {
        NonIncreasingInsertionSort nonIncreasingInsertionSort = new NonIncreasingInsertionSort();
        int[] given = {2, 1, 1, 4, 5, 3};
        nonIncreasingInsertionSort.sort(given);
        int[] expected = {5, 4, 3, 2, 1, 1};
        Assertions.assertArrayEquals(expected, given);
    }
}
