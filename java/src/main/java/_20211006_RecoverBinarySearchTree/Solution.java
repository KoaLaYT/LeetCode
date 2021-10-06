package _20211006_RecoverBinarySearchTree;

/**
 * @author koalayt 2021-10-06
 */
public class Solution {

    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        prev = null;
        first = null;
        second = null;
        inOrder(root);
        swap(first, second);
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }
        prev = node;
        inOrder(node.right);
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

}
