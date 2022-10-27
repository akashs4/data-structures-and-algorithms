package dsalgo.learning.geeksforgeeks.binarytree;

public class Easy_11_LCAInBST {

    public Node LCA(Node node, int n1, int n2) {
        // one on left, one on right
        // both on left
        // both on right
        if (node == null)
            return null;

        if (node.data < n1 && node.data < n2)
            return LCA(node.right, n1, n2);
        else if (node.data > n1 && node.data > n2)
            return LCA(node.left, n1, n2);

        return node;
    }
}
