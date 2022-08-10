package _20220810_ReverseKGroup;

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
    public int k;

    @Parameterized.Parameter(2)
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 2, new int[]{2, 1, 4, 3, 5}},
                {new int[]{1, 2, 3, 4, 5}, 3, new int[]{3, 2, 1, 4, 5}},
                {new int[]{1, 2, 3, 4, 5, 6}, 2, new int[]{2, 1, 4, 3, 6, 5}},
                {new int[]{1}, 1, new int[]{1}},
                {new int[]{1, 2}, 2, new int[]{2, 1}},
                {new int[]{1, 2, 3,}, 1, new int[]{1, 2, 3}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode head = Utils.buildList(input);
        ListNode result = solution.reverseKGroup(head, k);
        Utils.assertListEquals(expected, result);
    }

}