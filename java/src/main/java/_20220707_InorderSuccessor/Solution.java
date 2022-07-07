package _20220707_InorderSuccessor;

import common.TreeNode;

public class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null) {
            return null;
        }

        if (p.right != null) {
            return leftMostNode(p.right);
        }

        return parent(root, p);
    }

    private TreeNode leftMostNode(TreeNode node) {
        if (node.left != null) {
            return leftMostNode(node.left);
        }

        return node;
    }

    private TreeNode parent(TreeNode node, TreeNode p) {
        if (node == null || node == p) {
            return null;
        }

        if (p.val < node.val) {
            TreeNode found = parent(node.left, p);
            if (found != null) {
                return found;
            }
            return node;
        }

        return parent(node.right, p);
    }

}
