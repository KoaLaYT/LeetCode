package _20211002_ReverseLinkedListII;

/**
 * @author koalayt 2021-10-02
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left >= right) {
            return head;
        }

        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;

        ListNode first = tmpHead;
        int index = 0;
        while (first != null && index < left - 1) {
            first = first.next;
            index += 1;
        }
        if (first == null) {
            return head;
        }
        ListNode last = first.next;
        if (last == null) {
            return head;
        }
        ListNode current = last.next;
        index = left;

        while (current != null && index < right) {
            ListNode temp = first.next;
            first.next = current;
            last.next = current.next;
            current.next = temp;

            current = last.next;
            index += 1;
        }

        return tmpHead.next;
    }

}
