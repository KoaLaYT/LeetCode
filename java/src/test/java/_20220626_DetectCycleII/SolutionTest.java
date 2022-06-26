package _20220626_DetectCycleII;

import common.ListNode;
import org.junit.Assert;
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
    public int crossIndex;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{3, 2, 0, -4}, 1},
                {new int[]{1, 2}, 0},
                {new int[]{1}, -1},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 7},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, -1},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0},
                {new int[]{1, 2}, -1},
                };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        Utils.Pair<ListNode> expect = Utils.buildCycleList(input, crossIndex);
        ListNode             result = solution.detectCycle(expect.left);
        Assert.assertEquals(expect.right, result);
    }

}