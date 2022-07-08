package _20220708_DeleteNode;

import common.TreeNode;

public class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return deleteNode(root, null);
        }

        TreeNode[] deleteNodeAndParent = findDeleteNodeAndParent(root, key);

        if (deleteNodeAndParent != null) {
            deleteNode(deleteNodeAndParent[0], deleteNodeAndParent[1]);
        }
        // else
        // no such key, nothing to do

        return root;
    }

    private TreeNode[] findDeleteNodeAndParent(TreeNode node, int key) {
        while (node != null) {
            if (node.left != null && node.left.val == key) {
                return new TreeNode[]{node.left, node};
            }
            if (node.right != null && node.right.val == key) {
                return new TreeNode[]{node.right, node};
            }
            if (node.val < key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    private TreeNode deleteNode(TreeNode node, TreeNode parent) {
        TreeNode newNode;
        // node is leaf
        if (node.left == null && node.right == null) {
            newNode = null;
        }
        // node only has one child
        else if (node.left == null || node.right == null) {
            newNode = node.left == null ? node.right : node.left;
        }
        // node has both left and right children
        else {
            TreeNode[] successorAndParent = findSuccessorAndParent(node.right, node);
            TreeNode successor = successorAndParent[0];
            TreeNode successorParent = successorAndParent[1];
            // swap successor and node
            if (successorParent == node) {
                successor.left = node.left;
            } else {
                successorParent.left = successor.right;
                successor.left = node.left;
                successor.right = node.right;
            }
            newNode = successor;
        }

        if (parent == null) {
            return newNode;
        }

        if (parent.left == node) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return null;
    }

    private TreeNode[] findSuccessorAndParent(TreeNode node, TreeNode parent) {
        while (true) {
            if (node.left == null) {
                return new TreeNode[]{node, parent};
            }
            parent = node;
            node = node.left;
        }
    }

}
