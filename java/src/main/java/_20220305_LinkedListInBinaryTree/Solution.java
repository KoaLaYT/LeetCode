package _20220305_LinkedListInBinaryTree;

public class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (dfs(head, root)) {
            return true;
        }

        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode current, TreeNode node) {
        if (current == null) {
            return true;
        }

        if (node == null || current.val != node.val) {
            return false;
        }

        return dfs(current.next, node.left) || dfs(current.next, node.right);
    }

}
