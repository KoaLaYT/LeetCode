package _20220626_RemoveNthFromEnd;

import common.ListNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tools.Utils;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] input;

    @Parameterized.Parameter(1)
    public int n;

    @Parameterized.Parameter(2)
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 3, 5}},
                {new int[]{1}, 1, new int[]{}},
                {new int[]{1, 2}, 1, new int[]{1}},
                {new int[]{1, 2}, 2, new int[]{2}},
                };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode head   = Utils.buildList(input);
        ListNode result = solution.removeNthFromEnd(head, n);
        Utils.assertListEquals(expected, result);
    }

}