package dsalgo.learning.leetcode.array;

// Problem: https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
public class Medium_3_FindOriginalArrayOfPrefixXor {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] result = new int[n];
        result[0] = pref[0];

        for (int i = 1; i < n; i++)
            result[i] = pref[i - 1] ^ pref[i];

        return result;
        // can also modify given array from end and return simply that
    }
}
