package _20220217_PathSumII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, new LinkedList<>(), result);
        return result;
    }

    private void pathSum(TreeNode node, int left, LinkedList<Integer> path, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        path.addLast(node.val);
        left -= node.val;
        boolean isLeaf = isLeaf(node);
        if (left == 0 && isLeaf) {
            result.add(new ArrayList<>(path));
        } else if (!isLeaf) {
            pathSum(node.left, left, path, result);
            pathSum(node.right, left, path, result);
        }
        path.removeLast();
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}
