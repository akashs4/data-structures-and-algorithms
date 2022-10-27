package dsalgo.learning.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class Easy_5_IncreasingOrderSearchTree {

    //without using extra space
    private TreeNode head, current;
    public TreeNode increasingBST(TreeNode root){
        if(root == null)
            return null;
        increasingBST(root.left);
        root.left=null;
        if(head == null){
            head = root;
            current = head;
        }
        else{
            current.right = root;
            current = current.right;
        }
        increasingBST(root.right);

        return head;
    }

    // by using extra space
//    public TreeNode increasingBST(TreeNode root) {
//
//        List<TreeNode> list = new ArrayList<>();
//        inOrder(root, list);
//
//        TreeNode newNode = null, current = null;
//
//        for (TreeNode node : list) {
//            if (newNode == null) {
//                newNode = node;
//                current = newNode;
//            } else {
//                current.right = node;
//                current = current.right;
//            }
//        }
//
//        return newNode;
//    }
//
//    private void inOrder(TreeNode node, List<TreeNode> list) {
//        if (node == null)
//            return;
//
//        inOrder(node.left, list);
//        list.add(new TreeNode(node.val));
//        inOrder(node.right, list);
//    }
}
