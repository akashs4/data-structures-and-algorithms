package dsalgo.learning.leetcode.array;

import java.util.HashMap;
import java.util.Map;

// Problem: https://leetcode.com/problems/number-of-good-pairs/
public class Easy_3_NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++)
            map.compute(nums[i], (k, v) -> (v == null) ? 1 : v + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            count += (entry.getValue() * (entry.getValue() - 1)) / 2;

        return count;
    }
}

/*Idea:
 *
 * store the count of each number in map
 * if for a given number, we have x number of occurences,
 * than number of good pairs for that number will be (x*(x-1))/2
 * using above fact, we can calculate all possible good pairs for all repeated numbers
 *
 * Another way to calculate count in one iteration:
 * for each number in map, keep adding the value
 * Example:
 * [1,1,1,1]
 * in first iter:
 * add 0, save value 1
 * in second iter:
 * add 1, update value to 2
 * in third iter:
 * add 2, update value to 3
 * in fourth iter:
 * add 3, update value to 4
 * */
