package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
public class Easy_2_FindNodeInCloneTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null || original == target)
            return cloned;

        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null)
            return left;
        return getTargetCopy(original.right, cloned.right, target);
    }
}
