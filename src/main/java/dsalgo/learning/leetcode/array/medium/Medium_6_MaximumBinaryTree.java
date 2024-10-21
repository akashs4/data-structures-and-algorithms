package dsalgo.learning.leetcode.array.medium;

/** Problem: https://leetcode.com/problems/maximum-binary-tree/description/
 * Use monotonic stack to achieve better time complexity
  */
public class Medium_6_MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int start, int end){
        if(start > end)
            return null;

        TreeNode node = new TreeNode();
        int maxIndex = findMax(nums, start, end);
        node.val = nums[maxIndex];
        node.left = helper(nums, start, maxIndex-1);
        node.right = helper(nums, maxIndex+1, end);

        return node;
    }

    private int findMax(int[] nums, int start, int end){
        int maxIndex = start;
        for(int i=start ; i<=end ; i++){
            if(nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 6, 0, 5};
        Medium_6_MaximumBinaryTree obj = new Medium_6_MaximumBinaryTree();
        TreeNode node = obj.constructMaximumBinaryTree(arr);
        obj.inOrder(node);
    }

    public void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}