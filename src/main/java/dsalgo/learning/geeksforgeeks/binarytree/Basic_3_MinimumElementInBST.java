package dsalgo.learning.geeksforgeeks.binarytree;

public class Basic_3_MinimumElementInBST {
    public int minValue(Node node){
        if(node == null)
            return -1;

        int leftMin = minValue(node.left);
        if(leftMin==-1)
            return node.data;

        return leftMin;
    }
}
