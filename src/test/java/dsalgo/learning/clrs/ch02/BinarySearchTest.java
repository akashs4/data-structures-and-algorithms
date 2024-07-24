package dsalgo.learning.clrs.ch02;

import dsalgo.learning.clrs.ch02.exercises.IterativeBinarySearch;
import dsalgo.learning.clrs.ch02.exercises.RecursiveBinarySearch;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    @Test
    public void searchExistingElementUsingIterationTest() {
        int[] arr = new int[1000];
        Random random = new Random();
        Set<Integer> arrayNums = new HashSet<>();
        int num;
        for (int i = 0; i < 1000; i++) {
            num = random.nextInt(10000);
            while (arrayNums.contains(num)) {
                num = random.nextInt(10000);
            }
            arr[i] = num;
            arrayNums.add(num);
        }

        Arrays.sort(arr);
        for (int i = 0; i < 20; i++) {
            int index = random.nextInt(1000);
            int item = arr[index];

            int searchResult = IterativeBinarySearch.search(arr, item);
            assertEquals(index, searchResult);
        }
    }

    @Test
    public void searchExistingElementUsingRecursionTest() {
        int[] arr = new int[1000];
        Random random = new Random();
        Set<Integer> arrayNums = new HashSet<>();
        int num;
        for (int i = 0; i < 1000; i++) {
            num = random.nextInt(10000);
            while (arrayNums.contains(num)) {
                num = random.nextInt(10000);
            }
            arr[i] = num;
            arrayNums.add(num);
        }

        Arrays.sort(arr);
        for (int i = 0; i < 20; i++) {
            int index = random.nextInt(1000);
            int item = arr[index];

            int searchResult = RecursiveBinarySearch.search(arr, item, 0, arr.length - 1);
            assertEquals(index, searchResult);
        }
    }

    @Test
    public void searchNonExistingElementUsingRecursionTest() {
        int[] arr = new int[1000];
        Random random = new Random();
        Set<Integer> arrayNums = new HashSet<>();
        int num;
        for (int i = 0; i < 1000; i++) {
            num = random.nextInt(10000);
            while (arrayNums.contains(num)) {
                num = random.nextInt(10000);
            }
            arr[i] = num;
            arrayNums.add(num);
        }

        Arrays.sort(arr);
        for (int i = 0; i < 20; i++) {
            int item = arr[0];
            while(arrayNums.contains(item)){
                item = random.nextInt(10000);
            }

            int searchResult = RecursiveBinarySearch.search(arr, item, 0, arr.length - 1);
            assertEquals(-1, searchResult);
        }
    }

    @Test
    public void searchNonExistingElementUsingIteraionTest() {
        int[] arr = new int[1000];
        Random random = new Random();
        Set<Integer> arrayNums = new HashSet<>();
        int num;
        for (int i = 0; i < 1000; i++) {
            num = random.nextInt(10000);
            while (arrayNums.contains(num)) {
                num = random.nextInt(10000);
            }
            arr[i] = num;
            arrayNums.add(num);
        }

        Arrays.sort(arr);
        for (int i = 0; i < 20; i++) {
            int item = arr[0];
            while(arrayNums.contains(item)){
                item = random.nextInt(10000);
            }

            int searchResult = IterativeBinarySearch.search(arr, item);
            assertEquals(-1, searchResult);
        }
    }
}
