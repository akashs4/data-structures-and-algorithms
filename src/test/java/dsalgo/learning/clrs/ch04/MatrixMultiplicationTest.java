package dsalgo.learning.clrs.ch04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixMultiplicationTest {
    @Test
    public void testMatrixMultiplicationBruteForce() {
        int[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] m2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{30, 36, 42}, {66, 81, 96}, {102, 126, 150}};

        int[][] actual = MatrxiMultiplication.multiply(m1, m2);
        Assertions.assertArrayEquals(expected[0], actual[0]);
        Assertions.assertArrayEquals(expected[1], actual[1]);
        Assertions.assertArrayEquals(expected[2], actual[2]);
    }
}
