package _20220701_DistanceInTree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int distanceInTree(TreeNode root, int p, int q) {
        if (root == null) {
            return 0;
        }

        TreeNode ancestor = lowestCommonAncestor(root, p, q);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(ancestor);

        int distance = 0;
        int left = 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == p) {
                    left--;
                }
                if (node.val == q) {
                    left--;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (left == 0) break;
            distance += left;
        }

        return distance;
    }

    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }

}
