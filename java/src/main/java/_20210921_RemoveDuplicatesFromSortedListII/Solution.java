package _20210921_RemoveDuplicatesFromSortedListII;

/**
 * @author koalayt 2021-09-21
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                do {
                    curr = curr.next;
                } while (curr.next != null && curr.next.val == curr.val);
                curr = curr.next;
                continue;
            }

            if (prev != null) {
                prev.next = curr;
            } else {
                head = curr;
            }
            prev = curr;
            curr = curr.next;
        }

        if (prev != null) {
            prev.next = null;
        } else {
            head = null;
        }

        return head;
    }

}
