package dsalgo.learning.geeksforgeeks.binarytree;

public class Easy_8_MirrorTree {
    public void mirror(Node root) {
        if(root==null)
            return;

        Node left = root.left;
        root.left = root.right;
        root.right = left;

        mirror(root.left);
        mirror(root.right);
    }
}
