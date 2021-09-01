package _20210901_ValidateBinarySearchTree;

import java.util.Objects;

/**
 * @author koalayt 2021-09-01
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (Objects.isNull(node)) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val)
                && isValidBST(node.right, node.val, max);
    }

}
