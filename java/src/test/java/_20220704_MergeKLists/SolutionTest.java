package _20220704_MergeKLists;

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
    public int[][] inputs;

    @Parameterized.Parameter(1)
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}}, new int[]{1, 1, 2, 3, 4, 4, 5, 6}},
                {new int[][]{{}}, new int[]{}},
                {new int[][]{}, new int[]{}},
                {new int[][]{{}, {1}}, new int[]{1}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        ListNode[] lists = new ListNode[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            lists[i] = Utils.buildList(inputs[i]);
        }
        ListNode result = solution.mergeKLists(lists);
        Utils.assertListEquals(expected, result);
    }

}