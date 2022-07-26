package _20220726_SortList;

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
                {new int[]{4, 2, 1, 3}, new int[]{1, 2, 3, 4}},
                {new int[]{-1, 5, 3, 4, 0}, new int[]{-1, 0, 3, 4, 5}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode head = Utils.buildList(input);
        ListNode result = solution.sortList(head);
        Utils.assertListEquals(expected, result);
    }

}