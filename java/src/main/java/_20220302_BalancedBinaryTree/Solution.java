package _20220302_BalancedBinaryTree;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        try {
            getHeight(root, 0);
        } catch (NotBalancedException e) {
            return false;
        }

        return true;
    }

    private int getHeight(TreeNode node, int height) {
        if (node == null) {
            return height;
        }

        int leftHeight = getHeight(node.left, height + 1);
        int rightHeight = getHeight(node.right, height + 1);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            throw new NotBalancedException();
        }

        return Math.max(leftHeight, rightHeight);
    }

    private static class NotBalancedException extends RuntimeException {}

}
