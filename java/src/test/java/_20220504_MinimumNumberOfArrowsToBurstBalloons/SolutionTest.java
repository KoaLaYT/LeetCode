package _20220504_MinimumNumberOfArrowsToBurstBalloons;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] points;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}, 2},
                {new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}, 4},
                {new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 2},
                {new int[][]{{-2147483648, 2147483647}}, 1},
                {new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}}, 2},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.findMinArrowShots(points);
        Assert.assertEquals(expected, result);
    }

}