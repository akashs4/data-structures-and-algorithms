package dsalgo.learning.leetcode.binarytree;

public class Easy_17_BinaryTreeTilt {

    private int tiltVal = 0;

    public int findTilt(TreeNode root) {
        sum(root);
        return tiltVal;
    }

    private int sum(TreeNode root) {
        if (root == null)
            return 0;

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        tiltVal += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
}
