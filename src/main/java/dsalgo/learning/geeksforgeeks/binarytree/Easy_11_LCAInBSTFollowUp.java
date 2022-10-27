package dsalgo.learning.geeksforgeeks.binarytree;

public class Easy_11_LCAInBSTFollowUp {
    public Node LCA(Node node, int n1, int n2){
        if(node == null || node.data==n1 || node.data==n2)
            return node;

        Node left = LCA(node.left, n1, n2);
        Node right = LCA(node.left, n1, n2);

        if(left == null)
            return right;
        else if(right == null)
            return left;
        return node;

    }
}
