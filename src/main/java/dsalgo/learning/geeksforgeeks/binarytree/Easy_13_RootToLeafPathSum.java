package dsalgo.learning.geeksforgeeks.binarytree;

public class Easy_13_RootToLeafPathSum {
    public boolean hasPathSum(Node node, int s) {
        if(node == null)
            return false;
        if ((s - node.data) == 0 && node.left == null && node.right == null)
            return true;
        return hasPathSum(node.left, s - node.data) || hasPathSum(node.right, s - node.data);
    }
}
