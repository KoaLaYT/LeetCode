package _20220711_KthSmallestII;

import common.TreeNode;

public class Solution {

    public int kthSmallestII(TreeNode root, TreeNode nodenum_root, int k) {
        if (root == null) {
            return -1;
        }

        int left = kthSmallestII(root.left, nodenum_root.left, k);
        if (left >= 0) {
            return left;
        }

        k -= nodenum_root.left == null ? 0 : nodenum_root.left.val;

        if (k == 1) {
            return root.val;
        }

        return kthSmallestII(root.right, nodenum_root.right, k - 1);
    }

}
