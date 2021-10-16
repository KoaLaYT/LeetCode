package _20211016_BinaryTreeZigzagLevelOrderTraversal;

import java.util.*;

/**
 * @author koalayt 2021-10-16
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int direction = -1;

        while (!deque.isEmpty()) {
            int size = deque.size();
            result.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                TreeNode node = direction == -1 ? deque.pollLast() : deque.pollFirst();
                result.get(result.size() - 1).add(node.val);
                // desc
                if (direction == -1) {
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                }
                // asc
                else {
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                }
            }
            direction *= -1;
        }

        return result;
    }

}
