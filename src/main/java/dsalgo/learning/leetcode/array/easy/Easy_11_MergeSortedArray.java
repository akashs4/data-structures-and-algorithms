package dsalgo.learning.leetcode.array.easy;

// Problem url: https://leetcode.com/problems/merge-sorted-array/description/
public class Easy_11_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] memory = new int[m];
        System.arraycopy(nums1, 0, memory, 0, m);

        int i = 0, j = 0;
        for (int k = 0; k < m + n; k++) {
            if (i >= m)
                nums1[k] = nums2[j++];
            else if (j >= n)
                nums1[k] = memory[i++];
            else if (memory[i] < nums2[j])
                nums1[k] = memory[i++];
            else nums1[k] = nums2[j++];
        }
    }
}
