package _20210922_PartitionList;

/**
 * @author koalayt 2021-09-22
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode newHead = new ListNode(x - 1, head);

        ListNode first = newHead;
        while (first.next != null && first.next.val < x) {
            first = first.next;
        }
        if (first.next == null) {
            return head;
        }

        ListNode second = first.next;

        while (second.next != null) {
            if (second.next.val < x) {
                ListNode swap = second.next;
                second.next = swap.next;
                swap.next = first.next;
                first.next = swap;
                first = first.next;
            } else {
                second = second.next;
            }
        }

        return newHead.next;
    }

}
