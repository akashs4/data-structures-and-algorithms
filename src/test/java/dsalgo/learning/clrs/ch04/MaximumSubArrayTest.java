package dsalgo.learning.clrs.ch04;

import org.junit.jupiter.api.Test;

import static dsalgo.learning.clrs.ch04.MaximumSubArry.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubArrayTest {
    @Test
    public void testDivideAndConquerApproach() {
        // Test case 1: All positive numbers
        int[] arr1 = {1, 2, 3, 4, 5};
        assertEquals(15, divideAndConquerMaxSubArray(arr1));

        // Test case 2: All negative numbers
        int[] arr2 = {-1, -2, -3, -4, -5};
        assertEquals(-1, divideAndConquerMaxSubArray(arr2));

        // Test case 3: Mixed positive and negative numbers
        int[] arr3 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, divideAndConquerMaxSubArray(arr3));

        // Test case 4: Single element array
        int[] arr4 = {5};
        assertEquals(5, divideAndConquerMaxSubArray(arr4));

        // Test case 5: Empty array
        int[] arr5 = {};
        assertEquals(0, divideAndConquerMaxSubArray(arr5));
    }

    @Test
    public void testBruteForceApproach() {
        // Test case 1: All positive numbers
        int[] arr1 = {1, 2, 3, 4, 5};
        assertEquals(15, bruteForceMaxSubArry(arr1));

        // Test case 2: All negative numbers
        int[] arr2 = {-5, -2, -3, -4, -5};
        assertEquals(-2, bruteForceMaxSubArry(arr2));

        // Test case 3: Mixed positive and negative numbers
        int[] arr3 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, bruteForceMaxSubArry(arr3));

        // Test case 4: Single element array
        int[] arr4 = {5};
        assertEquals(5, bruteForceMaxSubArry(arr4));

        // Test case 5: Empty array
        int[] arr5 = {};
        assertEquals(0, bruteForceMaxSubArry(arr5));
    }

    @Test
    public void testLinearTimeApproach() {
        // Test case 1: All positive numbers
        int[] arr1 = {1, 2, 3, 4, 5};
        assertEquals(15, linearTimeMaxSubArray(arr1));

        // Test case 2: All negative numbers
        int[] arr2 = {-5, -2, -3, -4, -5};
        assertEquals(-2, linearTimeMaxSubArray(arr2));

        // Test case 3: Mixed positive and negative numbers
        int[] arr3 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, linearTimeMaxSubArray(arr3));

        // Test case 4: Single element array
        int[] arr4 = {5};
        assertEquals(5, linearTimeMaxSubArray(arr4));

        // Test case 5: Empty array
        int[] arr5 = {};
        assertEquals(0, linearTimeMaxSubArray(arr5));
    }
}
