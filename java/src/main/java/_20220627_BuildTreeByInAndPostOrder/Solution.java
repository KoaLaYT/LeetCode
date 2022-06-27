package _20220627_BuildTreeByInAndPostOrder;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = buildMap(inorder);
        int len = inorder.length;
        return buildTree(postorder, inOrderMap, 0, len - 1, 0, len - 1);
    }

    private TreeNode buildTree(int[] postOrder, Map<Integer, Integer> inOrderMap, int lp, int rp, int li, int ri) {
        if (lp < 0 || lp >= postOrder.length || lp > rp) {
            return null;
        }

        int val = postOrder[rp];
        TreeNode node = new TreeNode(val);
        if (lp != rp) {
            int pos = inOrderMap.get(val);
            int rightSize = ri - pos;
            node.left = buildTree(postOrder, inOrderMap, lp, rp - rightSize - 1, li, pos - 1);
            node.right = buildTree(postOrder, inOrderMap, rp - rightSize, rp - 1, pos + 1, ri);
        }
        return node;
    }

    private Map<Integer, Integer> buildMap(int[] order) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            result.put(order[i], i);
        }
        return result;
    }

}
