package _20220817_BinaryTreeRightSideView;

import common.TreeNode;

import java.util.*;

public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == size - 1) {
                    result.add(node.val);
                }
            }
        }

        return result;
    }

}
