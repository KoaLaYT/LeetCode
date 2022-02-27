package _20220227_FlattenBinaryTreeToLinkedList;

public class Solution {

    public void flatten(TreeNode root) {
//        flattenMethod1(root);
        flattenMethod2(root);
    }

    private void flattenMethod2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode last = curr.left;
                while (last.right != null) {
                    last = last.right;
                }
                last.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    private void flattenMethod1(TreeNode root) {
        if (root == null) {
            return;
        }

        flat(root);
    }

    private TreeNode flat(TreeNode node) {
        TreeNode right = node.right;
        TreeNode left = node.left;
        TreeNode last = node;

        if (left != null) {
            node.left = null;
            node.right = left;
            last = flat(left);
            last.right = right;
        }
        if (right != null) {
            last = flat(right);
        }
        return last;
    }

}
