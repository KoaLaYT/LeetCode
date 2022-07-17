package _20220717_TreeToDoublyList;

import common.TreeNode;
import lombok.NonNull;

public class Solution {

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        TwoEnd result = convert(root);
        result.leftMost.left = result.rightMost;
        result.rightMost.right = result.leftMost;

        return result.leftMost;
    }

    private TwoEnd convert(@NonNull TreeNode node) {

        TreeNode leftMost = node;
        if (node.left != null) {
            TwoEnd left = convert(node.left);
            left.rightMost.right = node;
            node.left = left.rightMost;
            leftMost = left.leftMost;
        }

        TreeNode rightMost = node;
        if (node.right != null) {
            TwoEnd right = convert(node.right);
            right.leftMost.left = node;
            node.right = right.leftMost;
            rightMost = right.rightMost;
        }

        return new TwoEnd(leftMost, rightMost);
    }

    private static class TwoEnd {
        TreeNode leftMost;
        TreeNode rightMost;

        TwoEnd(TreeNode leftMost, TreeNode rightMost) {
            this.leftMost = leftMost;
            this.rightMost = rightMost;
        }
    }

}
