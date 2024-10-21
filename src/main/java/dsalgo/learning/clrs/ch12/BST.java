package dsalgo.learning.clrs.ch12;

public class BST {

    public TreeNode search(TreeNode root, int key) {
        if (root == null || root.item == key) return root;
        else if (root.item > key) return search(root.left, key);
        return search(root.right, key);
    }

    public TreeNode iterativeSearch(TreeNode root, int key) {
        while (root != null && root.item != key) {
            if (root.item < key) root = root.right;
            else root = root.left;
        }
        return root;
    }

    public int minimum(TreeNode root) {
        if (root.left == null) return root.item;
        return minimum(root.left);
    }

    public int iterativeMinimum(TreeNode root) {
        while (root.left != null) root = root.left;
        return root.item;
    }

    public int maximum(TreeNode root) {
        if (root.right == null) return root.item;
        return maximum(root.right);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
    }

    public void successor() {
    }

    public void predecessor() {
    }

    private static class TreeNode {
        int item;
        TreeNode left;
        TreeNode right;
    }
}
