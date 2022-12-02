package dsalgo.learning.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

// Problem: https://leetcode.com/problems/binary-tree-pruning/
public class Medium_13_BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
//        height(root);
//        if (root.left == null && root.right == null && root.val == 0)
//            return null;
//        return root;
        // another way
        if (root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // and because if either left, right or current node has value 1, then we need to return current node
        if (root.left == null && root.right == null && root.val == 0)
            return null;
        return root;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();

        int n1 = ransomNote.length();
        for (int i = 0; i < n1; i++)
            ransomMap.compute(ransomNote.charAt(i), (k, v) -> (v == null) ? 0 : v + 1);

        int n2 = magazine.length();
        for (int i = 0; i < n2; i++)
            magazineMap.compute(magazine.charAt(i), (k, v) -> (v == null) ? 0 : v + 1);

        for (Map.Entry<Character, Integer> entry : ransomMap.entrySet()) {
            if (magazineMap.get(entry.getKey()) != entry.getValue())
                return false;
        }

        return true;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;

        int lH = height(root.left);
        if (lH == 0)
            root.left = null;

        int rH = height(root.right);
        if (rH == 0)
            root.right = null;

        return (lH == 1 || rH == 1 || root.val == 1) ? 1 : 0;
    }
}

/*Idea:
 * check if getting 0 from left, make left child null
 * perform same thing for right child
 * in the end return 1, if either left/right child or current node value is 1
 * */
