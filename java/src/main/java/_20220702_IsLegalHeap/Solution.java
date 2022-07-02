package _20220702_IsLegalHeap;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public boolean isLegalHeap(TreeNode root) {
        List<Integer> array = toArray(root);

        boolean isFull = isFullTree(array);
        if (!isFull) {
            return false;
        }

        if (array.size() <= 3) {
            return true;
        }

        Integer top = array.get(0);
        Integer left = array.get(1);
        Integer right = array.get(2);

        if (left == null) {
            return true;
        }

        if (right == null) {
            return true;
        }

        if (top >= left && top >= right) {
            return isValLegal(array, 0, Type.Max);
        }

        if (top <= left && top <= right) {
            return isValLegal(array, 0, Type.Min);
        }

        return false;
    }

    private List<Integer> toArray(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    result.add(null);
                } else {
                    result.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        return result;
    }

    private boolean isFullTree(List<Integer> array) {
        boolean findNull = false;

        for (Integer ele : array) {
            if (ele == null) {
                findNull = true;
            } else if (findNull) {
                return false;
            }
        }

        return true;
    }

    private boolean isValLegal(List<Integer> array, int index, Type type) {
        if (index >= array.size()) {
            return true;
        }

        Integer val = array.get(index);

        if (val == null) {
            return true;
        }

        Integer left = 2 * index + 1 < array.size() ? array.get(2 * index + 1) : null;
        Integer right = 2 * index + 2 < array.size() ? array.get(2 * index + 2) : null;

        if (left == null) {
            return true;
        }

        if (type == Type.Max && left > val) {
            return false;
        }

        if (type == Type.Min && left < val) {
            return false;
        }

        if (right == null) {
            return true;
        }

        if (type == Type.Max && right > val) {
            return false;
        }

        if (type == Type.Min && right < val) {
            return false;
        }

        return isValLegal(array, 2 * index + 1, type)
                && isValLegal(array, 2 * index + 2, type);
    }

    enum Type {
        Max, Min;
    }

}
