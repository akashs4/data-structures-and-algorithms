package dsalgo.learning.leetcode.binarytree;

public class Easy_14_ConstructStringFromBT {
    public String tree2str(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        pre(root, sb);
        System.out.println(sb.toString());

        return sb.toString();
    }

    private void pre(TreeNode root, StringBuffer sb) {
        if (root == null)
            return;

        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            pre(root.left, sb);
            sb.append(")");
        }

        if (root.right != null) {
            sb.append("(");
            pre(root.right, sb);
            sb.append(")");
        }
    }
}
