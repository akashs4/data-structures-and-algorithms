package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
// Below solution utilizes the fact that given tree is a special tree
public class Easy_27_SecondMinInBT {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;

        if (root.left == null && root.right == null)
            return -1;

        int left = root.left.val;
        int right = root.right.val;

        if (left == root.val) {
            left = findSecondMinimumValue(root.left);
        }

        if (right == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        if (left != -1 && right != -1)
            return Math.min(left, right);
        else if (left != -1)
            return left;
        else return right;
    }

    // Below finds second min in a normal binary tree
//    private int secondMin = -1;
//    private int min = Integer.MAX_VALUE;
//
//    public int findSecondMinimumValue(TreeNode root) {
//        helper(root);
//
//        // if(secondMin == Integer.MAX_VALUE)
//        //     return -1;
//
//        return secondMin;
//    }
//
//    private void helper(TreeNode root){
//        if(root == null)
//            return;
//
//        // System.out.println("min= "+min+", secondMin= "+secondMin);
//        if(root.val < min){
//            if(min != Integer.MAX_VALUE)
//                secondMin = min;
//            min = root.val;
//        }
//
//        if(root.val > min && (root.val<secondMin || secondMin==-1) ){
//            secondMin = root.val;
//        }
//
//        helper(root.left);
//        helper(root.right);
//    }

}
