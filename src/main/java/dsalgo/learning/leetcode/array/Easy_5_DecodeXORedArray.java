package dsalgo.learning.leetcode.array;

// Problem: https://leetcode.com/problems/decode-xored-array/
public class Easy_5_DecodeXORedArray {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] result = new int[n + 1];
        result[0] = first;

        for (int i = 1; i <= n; i++) {
            result[i] = encoded[i - 1] ^ first;
            first = result[i];
        }

        return result;
    }

}
