package _20220814_InsertionSortList;

import common.ListNode;

public class Solution {

  public ListNode insertionSortList(ListNode head) {
    ListNode last = head;
    ListNode node = head.next;

    while (node != null) {
      if (last.val <= node.val) {
        last = node;
        node = node.next;
        continue;
      }

      ListNode prev = null;
      ListNode iter = head;
      while (iter != node) {
        if (iter.val >= node.val) {
          ListNode tmp = node.next;
          node.next = iter;
          last.next = tmp;
          if (prev != null) {
            prev.next = node;
          } else {
            head = node;
          }
          break;
        } else {
          prev = iter;
          iter = iter.next;
        }
      }

      node = last.next;
    }

    return head;
  }


}
