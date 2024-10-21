package dsalgo.learning.leetcode.heap;

import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-number-game/
public class Easy_1_MinimumNumberGame {
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(n);
        int[] arr = new int[n];

        for (int num : nums)
            pq.offer(num);

        int bob = 0, alice = 0, i = 0;
        while (i < n && !pq.isEmpty()) {
            alice = pq.poll();
            bob = pq.poll();
            arr[i++] = bob;
            arr[i++] = alice;
        }

        return arr;
    }
}
