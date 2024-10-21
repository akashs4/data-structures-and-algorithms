package dsalgo.learning.leetcode.array.medium;

// Problem: https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
public class Medium_3_FindOriginalArrayOfPrefixXor {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n];

        int temp = pref[0];
        arr[0] = temp;

        for (int i = 1; i < n; i++) {
            arr[i] = temp ^ pref[i];
            temp = temp ^ arr[i];
        }

        return arr;
        // can also modify given array from end and return simply that
    }

    public static void main(String[] args) {
        System.out.println(5^2);

        /**
         *
         * arr[i] -> (i>0 ? pref[i-1] : 0) ^ pref[i]
         *
         * */
    }
}
