package _20220215_ConvertSortedListToBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = listNodeToArray(head);
        return sortedListToBST(list, 0, list.size() - 1);
    }

    private List<Integer> listNodeToArray(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    private TreeNode sortedListToBST(List<Integer> list, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mi = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(list.get(mi));
        node.left = sortedListToBST(list, lo, mi - 1);
        node.right = sortedListToBST(list, mi + 1, hi);
        return node;
    }

}
