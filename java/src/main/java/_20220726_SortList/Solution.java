package _20220726_SortList;

import common.ListNode;

public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode[] splits = split(head);

        ListNode odd = sortList(splits[0]);
        ListNode even = sortList(splits[1]);

        return merge(odd, even);
    }

    private ListNode[] split(ListNode node) {
        ListNode odd = node;
        ListNode even = node.next;
        ListNode oddTail = odd;
        ListNode evenTail = even;
        boolean isOddTurn = true;

        for (ListNode iter = even.next; iter != null; iter = iter.next) {
            if (isOddTurn) {
                oddTail.next = iter;
                oddTail = oddTail.next;
            } else {
                evenTail.next = iter;
                evenTail = evenTail.next;
            }
            isOddTurn = !isOddTurn;
        }

        oddTail.next = null;
        evenTail.next = null;

        return new ListNode[]{odd, even};
    }

    private ListNode merge(ListNode odd, ListNode even) {
        ListNode sortedHead = null;

        if (odd.val <= even.val) {
            sortedHead = odd;
            odd = odd.next;
        } else {
            sortedHead = even;
            even = even.next;
        }

        ListNode iter = sortedHead;

        while (odd != null && even != null) {
            if (odd.val <= even.val) {
                iter.next = odd;
                odd = odd.next;
            } else {
                iter.next = even;
                even = even.next;
            }
            iter = iter.next;
        }

        while (odd != null) {
            iter.next = odd;
            iter = iter.next;
            odd = odd.next;
        }

        while (even != null) {
            iter.next = even;
            iter = iter.next;
            even = even.next;
        }

        return sortedHead;
    }

}
