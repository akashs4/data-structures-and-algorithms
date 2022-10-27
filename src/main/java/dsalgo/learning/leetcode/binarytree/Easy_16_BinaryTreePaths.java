package dsalgo.learning.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Easy_16_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> allPaths = new LinkedList<>();
        helper(root, "", allPaths);
        return allPaths;
    }

    private void helper(TreeNode node, String path, LinkedList<String> allPaths) {
        if (node == null)
            return;

        if (isLeaf(node))
            allPaths.add(path + node.val);
        else{
            helper(node.left, path + node.val + "->", allPaths);
            helper(node.right, path + node.val + "->", allPaths);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
