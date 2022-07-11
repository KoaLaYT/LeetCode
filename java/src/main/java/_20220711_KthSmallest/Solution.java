package _20220711_KthSmallest;

import common.TreeNode;

public class Solution {

    private int toVisit;

    public int kthSmallest(TreeNode root, int k) {
        this.toVisit = k;
        return kthSmallest(root);
    }

    private int kthSmallest(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int left = kthSmallest(node.left);
        if (left >= 0) {
            return left;
        }
        if (toVisit == 1) {
            return node.val;
        }
        toVisit--;
        return kthSmallest(node.right);
    }

}
