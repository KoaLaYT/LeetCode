package _20221110_AddTwoNumberII;

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
    public int[] a1;

    @Parameterized.Parameter(1)
    public int[] a2;

    @Parameterized.Parameter(2)
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{7, 2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 8, 0, 7}},
                {new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{8, 0, 7}},
                {new int[]{0}, new int[]{0}, new int[]{0}},
                {new int[]{4, 4, 3}, new int[]{5, 6, 4}, new int[]{1, 0, 0, 7}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode l1 = Utils.buildList(a1);
        ListNode l2 = Utils.buildList(a2);
        ListNode result = solution.addTwoNumbers(l1, l2);
        Utils.assertListEquals(expected, result);
    }

}