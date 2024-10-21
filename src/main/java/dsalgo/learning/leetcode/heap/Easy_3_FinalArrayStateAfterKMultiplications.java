package dsalgo.learning.leetcode.heap;

import java.util.PriorityQueue;

public class Easy_3_FinalArrayStateAfterKMultiplications {
    // brute force
//    public int[] getFinalState(int[] nums, int k, int multiplier) {
//        for (int i = 0; i < k; i++) {
//            int min = nums[0], minIndex = 0;
//
//            for (int j = 1; j < nums.length; j++) {
//                if (nums[j] < min) {
//                    minIndex = j;
//                    min = nums[j];
//                }
//            }
//            nums[minIndex] = nums[minIndex] * multiplier;
//        }
//
//        return nums;
//    }

    // Using Priority Queue
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> {
            int valueComparison = x.getValue().compareTo(y.getValue());
            return valueComparison == 0 ? x.getKey().compareTo(y.getKey()) : valueComparison;
        });

        for (int i = 0; i < nums.length; i++)
            pq.offer(new Pair<>(i, nums[i]));

        for (int i = 0; i < k; i++) {
            Pair<Integer, Integer> min = pq.poll();
            int minValue = min.getValue();
            int minIndex = min.getKey();
            nums[minIndex] = minValue * multiplier;
            pq.offer(new Pair<>(minIndex, nums[minIndex]));
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2};
        Easy_3_FinalArrayStateAfterKMultiplications obj = new Easy_3_FinalArrayStateAfterKMultiplications();
        for (int num : obj.getFinalState(nums, 4, 4))
            System.out.print(num + " ");

    }

    class Pair<X, Y> {
        X x;
        Y y;

        Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        X getKey() {
            return x;
        }

        Y getValue() {
            return y;
        }

    }
}