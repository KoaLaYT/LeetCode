package _20220315_MinimumPathSum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] grid;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}, 7},
                {new int[][]{{1, 2, 3}, {4, 5, 6}}, 12},
                {new int[][]{{1, 2}}, 3},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minPathSum(grid);
        Assert.assertEquals(expected, result);
    }

}