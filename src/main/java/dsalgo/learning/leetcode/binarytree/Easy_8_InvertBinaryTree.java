package dsalgo.learning.leetcode.binarytree;

// Problem Link: https://leetcode.com/problems/invert-binary-tree/
public class Easy_8_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root){
        // base condition
        if(root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // iterative way used BFS/ lvl order traversal, in each iteration we use temporary variable to swap nodes
    // push children and continue
}
