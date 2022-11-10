package _20221110_AddTwoNumberII;

import common.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = len(l1);
        int len2 = len(l2);

        ListNode n1 = padLeadingZero(l1, len1, len2);
        ListNode n2 = padLeadingZero(l2, len2, len1);

        Result result = add(n1, n2);
        if (result.carry == 0) {
            return result.node;
        } else {
            return new ListNode(1, result.node);
        }
    }

    private int len(ListNode node) {
        int result = 0;
        while (node != null) {
            node = node.next;
            result += 1;
        }
        return result;
    }

    private ListNode padLeadingZero(ListNode node, int nodeLen, int otherLen) {
        if (nodeLen >= otherLen) {
            return node;
        }
        int diff = otherLen - nodeLen;
        ListNode result = node;
        while (diff > 0) {
            result = new ListNode(0, result);
            diff -= 1;
        }
        return result;
    }

    private Result add(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return new Result(null, 0);
        }

        Result result = add(n1.next, n2.next);
        int sum = n1.val + n2.val + result.carry;
        return new Result(new ListNode(sum % 10, result.node), sum / 10);
    }

    private static class Result {
        ListNode node;
        int carry;

        Result(ListNode node, int carry) {
            this.node = node;
            this.carry = carry;
        }
    }

}
