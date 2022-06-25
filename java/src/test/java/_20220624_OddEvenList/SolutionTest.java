package _20220624_OddEvenList;

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
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, new int[]{1, 3, 5, 2, 4}},
                {new int[]{2, 1, 3, 5, 6, 4, 7}, new int[]{2, 3, 6, 7, 1, 5, 4}},
                {new int[]{}, new int[]{}},
                };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode head   = Utils.buildList(input);
        ListNode result = solution.oddEvenList(head);
        Utils.assertListEquals(expected, result);
    }

}