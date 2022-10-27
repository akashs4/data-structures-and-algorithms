package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class Easy_12_ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums){
        int n =nums.length;
        if(n==0)
            return null;

        TreeNode root = helper(nums, 0, n-1);
        return root;
    }

    private TreeNode helper(int[] nums, int start, int end){
        if(start>end)
            return null;

        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid-1);
        node.right = helper(nums, mid+1, end);

        return node;
    }
}
