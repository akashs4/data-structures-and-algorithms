package dsalgo.learning.geeksforgeeks.binarytree;

public class Basic_7_CountNonLeafNodesInTree {
  public int countNonLeafNodes(Node root) {
    if (root == null) return 0;

    int val = 0;
    if (root.left == null && root.right == null) val = 0;
    else if (root.left != null || root.right != null) val = 1;

    return val + countNonLeafNodes(root.left) + countNonLeafNodes(root.right);
  }
}

/*
left        right
null        not null
not null    null
not null    not null


* */
