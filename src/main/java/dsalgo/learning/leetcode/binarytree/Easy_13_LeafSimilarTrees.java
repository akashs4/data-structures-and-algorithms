package dsalgo.learning.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

// Problem: https://leetcode.com/problems/leaf-similar-trees/
// Space saving way using stack: https://leetcode.com/problems/leaf-similar-trees/discuss/152329/C%2B%2BJavaPython-O(H)-Space
public class Easy_13_LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSequence1 = new ArrayList<>();
        List<Integer> leafSequence2 = new ArrayList<>();
        leafFinder(root1, leafSequence1);
        leafFinder(root2, leafSequence2);

        if (leafSequence1.size() != leafSequence2.size())
            return false;

        for (int i = 0; i < leafSequence1.size(); i++) {
            int num1 = leafSequence1.get(i);
            int num2 = leafSequence2.get(i);

            if (num1 != num2)
                return false;
        }

        return true;
    }

    private void leafFinder(TreeNode root, List<Integer> leafSeq) {
        if (root == null)
            return;

        if (isLeaf(root))
            leafSeq.add(root.val);
        leafFinder(root.left, leafSeq);
        leafFinder(root.right, leafSeq);
    }

    private boolean isLeaf(TreeNode root) {
        return (root.left == null && root.right == null);
    }
}
