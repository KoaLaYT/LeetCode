package _20220330_BinaryTreeUpsideDown;

public class Solution {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return upsideDown(root);
    }

    private TreeNode upsideDown(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node;
        }

        TreeNode root = upsideDown(node.left);

        TreeNode left = node.left;
        TreeNode right = node.right;
        left.left = right;
        left.right = node;
        node.left = null;
        node.right = null;

        return root;
    }

}
