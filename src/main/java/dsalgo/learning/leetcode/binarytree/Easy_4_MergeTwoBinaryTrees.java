package dsalgo.learning.leetcode.binarytree;

public class Easy_4_MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;
        TreeNode newNode = new TreeNode();

        newNode.val = (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val);
        newNode.left = mergeTrees((root1 == null ? null : root1.left), (root2 == null ? null : root2.left));
        newNode.right = mergeTrees((root1 == null ? null : root1.right), (root2 == null ? null : root2.right));

        return newNode;
    }
    // another way would be to use the shared tree instead of creating extra space
    // if(root1==null) return root2; vice versa
}
