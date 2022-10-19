package _20221019_PathSumIII;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1);

        return pathSum(root, targetSum, 0, prefixSum);
    }

    private int pathSum(TreeNode node, long targetSum, long currentSum, Map<Long, Integer> prefixSum) {
        if (node == null) {
            return 0;
        }

        int path = 0;
        currentSum += node.val;
        path += prefixSum.getOrDefault(currentSum - targetSum, 0);
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        path += pathSum(node.left, targetSum, currentSum, prefixSum);
        path += pathSum(node.right, targetSum, currentSum, prefixSum);
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) - 1);
        return path;
    }

}
