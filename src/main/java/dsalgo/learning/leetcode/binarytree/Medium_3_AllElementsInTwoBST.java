package dsalgo.learning.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

// Problem: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
public class Medium_3_AllElementsInTwoBST {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inOrder(root1, list1);
        inOrder(root2, list2);

        int n1 = list1.size();
        int n2 = list2.size();

        for (int i = 0, j = 0; i < n1 || j < n2; ) {
            if (i >= n1) result.add(list2.get(j++));
            else if (j >= n2) result.add(list1.get(i++));
            else if (list1.get(i) < list2.get(j)) result.add(list1.get(i++));
            else result.add(list2.get(j++));
        }
        return result;
    }
    // [1,2,4], [0,1,3]

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

}
