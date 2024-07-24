package dsalgo.learning.clrs.ch02;

import dsalgo.learning.clrs.ch02.exercises.TwoSumExists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TwoSumExistsTest {

    @Test
    public void pairExistTest() {
        int[] arr = new int[1000];
        Random random = new Random();

        for (int y = 0; y < 20; y++) {
            for (int i = 0; i < 1000; i++)
                arr[i] = random.nextInt(10000);

            int left = 0, right = 0;
            while (left == right) {
                left = random.nextInt(1000);
                right = random.nextInt(1000);
            }

            int x = arr[left] + arr[right];

            Assertions.assertTrue(TwoSumExists.check(arr, x));
        }
    }

    @Test
    public void pairDoesNotExistTest() {
        int[] arr = new int[1000];
        Random random = new Random();
        for (int y = 0; y < 20; y++) {
            for (int i = 0; i < 1000; i++) {
                arr[i] = random.nextInt(10000);
            }

            int x = getX(arr, random);
            Assertions.assertFalse(TwoSumExists.check(arr, x));
        }
        ;
    }

    private static int getX(int[] arr, Random random) {
        Set<Integer> allSums = new HashSet<>();
        int[] newArr = new int[1000];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        Arrays.sort(newArr);

        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                allSums.add(sum);
            }
        }

        int x = sum;
        while (allSums.contains(x)) {
            x = random.nextInt(100000);
        }
        return x;
    }
}
