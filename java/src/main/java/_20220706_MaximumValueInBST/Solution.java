package _20220706_MaximumValueInBST;

import common.TreeNode;

public class Solution {

    public int maximumValueInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return max(root);
    }

    private int max(TreeNode node) {
        if (node.right == null) {
            return node.val;
        }
        return max(node.right);
    }

}
