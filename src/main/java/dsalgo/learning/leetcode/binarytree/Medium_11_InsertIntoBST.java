package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class Medium_11_InsertIntoBST {

    private boolean merged = false;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);

        return root;
    }

    //Iterative, TC: O(n), SC: O(1)
    public TreeNode insertIntobst(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        TreeNode node = root;
        while (true) {
            if (node.val < val) {
                if (node.right != null)
                    node = node.right;
                else {
                    node.right = new TreeNode(val);
                    break;
                }
            } else {
                if (node.left != null)
                    node = node.left;
                else {
                    node.left = new TreeNode(val);
                    break;
                }
            }

        }

        return root;
    }

}

/*Idea:
 * get all values in a list including given val (list should contain val in correct position so that list is sorted)
 * construct BST from sorted list
 * TC: O(n)
 * SC: O(h), h->height of tree
 * */
