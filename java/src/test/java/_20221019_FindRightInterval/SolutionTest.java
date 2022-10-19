package _20221019_FindRightInterval;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] intervals;

    @Parameterized.Parameter(1)
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{1, 2}}, new int[]{-1}},
                {new int[][]{{3, 4}, {2, 3}, {1, 2}}, new int[]{-1, 0, 1}},
                {new int[][]{{1, 4}, {2, 3}, {3, 4}}, new int[]{-1, 2, -1}},
                {new int[][]{{1, 1}, {3, 4}}, new int[]{0, -1}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] result = solution.findRightInterval(intervals);
        Assert.assertArrayEquals(expected, result);
    }

}