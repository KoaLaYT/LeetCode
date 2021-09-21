package _20210921_RemoveDuplicatesFromSortedList;

/**
 * @author koalayt 2021-09-21
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (prev.val != curr.val) {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }

        prev.next = null;

        return head;
    }

}
