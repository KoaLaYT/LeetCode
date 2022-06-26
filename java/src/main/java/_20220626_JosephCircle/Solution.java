package _20220626_JosephCircle;

public class Solution {

    public int[] Joseph_circle(int[] people, int k) {
        if (people == null || people.length == 1 || k == 1) {
            return people;
        }

        int[] result = new int[people.length];
        ListNode[] list = ListNode.buildCycle(people);

        int n = 1;
        int i = 0;
        ListNode cur = list[0];
        ListNode pre = list[1];

        while (i < people.length) {
            if (n % k == 0) {
                result[i++] = cur.val;
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            n++;
            cur = cur.next;
        }

        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this(val, null);
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        private static ListNode[] buildCycle(int[] input) {
            ListNode last = new ListNode(input[input.length - 1]);
            ListNode head = last;
            for (int i = input.length - 2; i >= 0; i--) {
                head = new ListNode(input[i], head);
            }
            last.next = head;
            return new ListNode[]{head, last};
        }
    }
}
