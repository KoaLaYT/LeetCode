package _20220812_SumRootToLeafNumbers;

import common.TreeNode;
import lombok.NonNull;

public class Solution {

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbers(root, 0);
    }

    private int sumNumbers(@NonNull TreeNode node, int val) {
        val = val * 10 + node.val;

        if (node.left == null && node.right == null) {
            return val;
        }

        int res = 0;

        if (node.left != null) {
            res += sumNumbers(node.left, val);
        }

        if (node.right != null) {
            res += sumNumbers(node.right, val);
        }

        return res;
    }

}
