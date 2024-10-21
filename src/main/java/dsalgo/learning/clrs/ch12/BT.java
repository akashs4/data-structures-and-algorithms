package dsalgo.learning.clrs.ch12;

public class BT<T> {

    public void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.item + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.item + " ");
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.item + " ");
    }

    private class TreeNode {
        T item;
        TreeNode left;
        TreeNode right;
    }
}
