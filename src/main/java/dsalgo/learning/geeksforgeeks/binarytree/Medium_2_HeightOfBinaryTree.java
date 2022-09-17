package dsalgo.learning.geeksforgeeks.binarytree;

/* Problem Description: Find height of binary tree */
public class Medium_2_HeightOfBinaryTree {

    public int height(Node node){
        return (node==null)?0: 1+Math.max(height(node.left), height(node.right));
    }
}
