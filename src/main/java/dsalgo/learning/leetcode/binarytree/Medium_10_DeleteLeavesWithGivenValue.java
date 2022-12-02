package dsalgo.learning.leetcode.binarytree;

// https://leetcode.com/problems/delete-leaves-with-a-given-value/
public class Medium_10_DeleteLeavesWithGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target)
            return null;
        return root;
    }
}
/*Idea:
* Since recursion acts as stack, we can recursively evaluate each node with condition at line 12
* just before exiting from it
* computation is to evalue left and right children
*
* */