package _20220624_ReverseList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] input;

    @Parameterized.Parameter(1)
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}},
                {new int[]{1, 2}, new int[]{2, 1}},
                {new int[]{}, new int[]{}},
                };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode head   = buildList(input);
        ListNode result = solution.reverseList(head);
        equals(expected, result);
    }

    private static ListNode buildList(int[] input) {
        ListNode head = null;
        for (int i = input.length - 1; i >= 0; i--) {
            head = new ListNode(input[i], head);
        }
        return head;
    }

    private static void equals(int[] expected, ListNode result) {
        int      i   = 0;
        ListNode cur = result;
        while (i < expected.length && cur != null) {
            Assert.assertEquals(expected[i], cur.val);
            cur = cur.next;
            i++;
        }
        Assert.assertEquals(i, expected.length);
        Assert.assertNull(cur);
    }

}