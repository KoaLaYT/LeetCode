package _20220701_SimilarTwoParts;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int similarTwoParts(TreeNode root) {
        Map<TreeNode, Integer> sums = new HashMap<>();
        buildSums(root, sums);
        int max = sums.get(root);
        int left = similar(root.left, sums, max, Integer.MAX_VALUE);
        int right = similar(root.right, sums, max, Integer.MAX_VALUE);
        return Math.min(left, right);
    }

    private int similar(TreeNode node, Map<TreeNode, Integer> sums, int max, int min) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int sum = sums.get(node);
        int diff = Math.abs(max - 2 * sum);

        min = Math.min(min, diff);
        min = Math.min(min, similar(node.left, sums, max, min));
        min = Math.min(min, similar(node.right, sums, max, min));

        return min;
    }

    private int buildSums(TreeNode node, Map<TreeNode, Integer> sums) {
        if (node == null) {
            return 0;
        }
        int left = buildSums(node.left, sums);
        int right = buildSums(node.right, sums);
        int sum = node.val + left + right;
        sums.put(node, sum);

        return sum;
    }

}
