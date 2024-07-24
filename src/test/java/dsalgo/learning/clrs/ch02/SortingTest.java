package dsalgo.learning.clrs.ch02;

import dsalgo.learning.clrs.ch02.exercises.BubbleSort;
import dsalgo.learning.clrs.ch02.exercises.NonIncreasingInsertionSort;
import dsalgo.learning.clrs.ch02.exercises.SelectionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SortingTest {
    @Test
    public void testMergeSort() {
        int[] arr = new int[1000];
        Random random = new Random();

        for (int x = 0; x < 20; x++) {
            for (int i = 0; i < 1000; i++)
                arr[i] = random.nextInt(10000);

            int[] expectedArr = Arrays.copyOf(arr, arr.length);
            Arrays.sort(expectedArr);
            MergeSort.sort(arr, 0, arr.length - 1);

            Assertions.assertArrayEquals(expectedArr, arr);
        }
    }

    @Test
    public void testInsertionSort() {
        int[] arr = new int[1000];
        Random random = new Random();
        for (int x = 0; x < 20; x++) {
            for (int i = 0; i < 1000; i++)
                arr[i] = random.nextInt(10000);

            int[] expectedArr = Arrays.copyOf(arr, arr.length);
            Arrays.sort(expectedArr);
            InsertionSort.sort(arr);

            Assertions.assertArrayEquals(expectedArr, arr);
        }
    }

    @Test
    public void testNonIncreasingInsertionSort() {
        Integer[] arr = new Integer[1000];
        Random random = new Random();
        for (int x = 0; x < 20; x++) {
            for (int i = 0; i < 1000; i++)
                arr[i] = random.nextInt(10000);

            Integer[] expectedArr = Arrays.copyOf(arr, arr.length);
            Arrays.sort(expectedArr, Collections.reverseOrder());
            NonIncreasingInsertionSort.sort(arr);

            Assertions.assertArrayEquals(expectedArr, arr);
        }
    }

    @Test
    public void testSelectionSort() {
        int[] arr = new int[1000];
        Random random = new Random();
        for (int x = 0; x < 20; x++) {
            for (int i = 0; i < 1000; i++)
                arr[i] = random.nextInt(10000);

            int[] expectedArr = Arrays.copyOf(arr, arr.length);
            Arrays.sort(expectedArr);
            SelectionSort.sort(arr);

            Assertions.assertArrayEquals(expectedArr, arr);
        }
    }

    @Test
    public void testBubbleSort() {
        int[] arr = new int[1000];
        Random random = new Random();
        for (int x = 0; x < 20; x++) {
            for (int i = 0; i < 1000; i++)
                arr[i] = random.nextInt(10000);

            int[] expectedArr = Arrays.copyOf(arr, arr.length);
            Arrays.sort(expectedArr);
            BubbleSort.sort(arr);

            Assertions.assertArrayEquals(expectedArr, arr);
        }
    }
}
