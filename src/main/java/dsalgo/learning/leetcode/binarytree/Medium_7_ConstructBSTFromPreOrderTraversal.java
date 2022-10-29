package dsalgo.learning.leetcode.binarytree;

// Problem: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class Medium_7_ConstructBSTFromPreOrderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (end < start)
            return null;
        if (start == end)
            return new TreeNode(preorder[start]);

        TreeNode root = new TreeNode(preorder[start]);
        int leftEnd = start;
        for (int i = start + 1; i <= end && preorder[i] < preorder[start]; i++)
            leftEnd = i;

        root.left = helper(preorder, start + 1, leftEnd);

        int rightStart = leftEnd + 1;
        root.right = helper(preorder, rightStart, end);

        return root;
    }
}

/*
Example: [8,5,1,7,10,12]
leftEnd -> 3
              8
            5    10
          1   7     12
 * Idea:
 *
 * helper(preorder, start, end)
 * base condition:
 * if(start<=end) return null;
 *
 *
 * create new TreeNode instance, and newNode.val = preorder[start]
 *
 * // find leftEnd-
 * for(i=start;i<=end;i++){
 * if(preorder[i]>preorder[start]){break};
 * else if(preorder[i]<preorder[start]){leftEnd=i;}
 * }
 *
 *
 * helper(preorder, start, leftEnd)
 *
 * // find rightStart
 * rightStart=leftEnd+1;
 * helper(preorder, rightStart, end)
 *
 * */
