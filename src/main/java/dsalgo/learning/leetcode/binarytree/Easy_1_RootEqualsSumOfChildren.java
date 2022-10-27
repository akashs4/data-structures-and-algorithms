package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/root-equals-sum-of-children/
public class Easy_1_RootEqualsSumOfChildren {
    public boolean checkTree(TreeNode root){
        return root.val == (root.left.val+root.right.val);
    }
}
