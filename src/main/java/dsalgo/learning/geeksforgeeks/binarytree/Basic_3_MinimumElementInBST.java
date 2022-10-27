package dsalgo.learning.geeksforgeeks.binarytree;

public class Basic_3_MinimumElementInBST {
   public int minValue(Node node){
       if(node==null)
           return -1;

       if(node.left!=null)
           return minValue(node.left);
       else return node.data;
   }
}
