package _20220821_CountCompleteTreeNodes;

import common.TreeNode;

public class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = treeHeight(root, 1);
        int lastLevel = countNodes(root, 1, height);
        return (int) Math.pow(2, height - 1) - 1 + lastLevel;
    }

    private int treeHeight(TreeNode node, int level) {
        if (node.left == null) {
            return level;
        }
        return treeHeight(node.left, level + 1);
    }

    private int countNodes(TreeNode node, int level, int target) {
        if (node == null) {
            return 0;
        }

        if (level == target) {
            return 1;
        }

        int count = countNodes(node.left, level + 1, target);
        int expected = (int) Math.pow(2, target - level - 1);

        if (count < expected) {
            return count;
        }

        return count + countNodes(node.right, level + 1, target);
    }

}
