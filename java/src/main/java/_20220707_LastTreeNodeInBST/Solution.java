package _20220707_LastTreeNodeInBST;

import common.TreeNode;

public class Solution {

    public TreeNode lastTreeNodeInBST(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        if (root.val < k) {
            return lastTreeNodeInBST(root.right, k);
        }

        if (root.val > k) {
            return lastTreeNodeInBST(root.left, k);
        }

        TreeNode found = lastTreeNodeInBST(root.right, k);
        if (found != null) {
            return found;
        }

        return root;

    }

}
