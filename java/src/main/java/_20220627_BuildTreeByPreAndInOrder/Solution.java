package _20220627_BuildTreeByPreAndInOrder;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = buildMap(inorder);
        int len = preorder.length;
        return buildTree(preorder, inOrderMap, 0, len - 1, 0, len - 1);
    }

    private TreeNode buildTree(
            int[] preorder,
            Map<Integer, Integer> inOrder,
            int lp, int rp,
            int li, int ri) {
        if (lp < 0 || lp >= preorder.length || lp > rp) {
            return null;
        }

        int val = preorder[lp];
        TreeNode node = new TreeNode(val);
        if (lp != rp) {
            int pos = inOrder.get(val);
            int leftSize = pos - li;
            node.left = buildTree(preorder, inOrder, lp + 1, lp + leftSize, li, pos - 1);
            node.right = buildTree(preorder, inOrder, lp + leftSize + 1, rp, pos + 1, ri);
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
