package _20220123_BinaryTreeLevelOrderTraversalII;

import java.util.*;

public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        levelOrderBottom(root, result);
        return result;
    }

    private void levelOrderBottom(TreeNode root, LinkedList<List<Integer>> result) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.addFirst(level);
        }
    }

}
