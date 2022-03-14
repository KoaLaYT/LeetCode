package _20220314_UniquePathsII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] obstacleGrid;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, 2},
                {new int[][]{{0, 1}, {0, 0}}, 1},
                {new int[][]{
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1, 0},
                        {0, 0, 0, 0, 0, 0}}, 10},
                {new int[][]{{1, 0}}, 0},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.uniquePathsWithObstacles(obstacleGrid);
        Assert.assertEquals(expected, result);
    }

}