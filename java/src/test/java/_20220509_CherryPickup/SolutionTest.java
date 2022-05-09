package _20220509_CherryPickup;

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
                {new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}, 5},
                {new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}}, 0},
                {new int[][]{{0, 0, -1}, {1, 0, -1}, {1, 1, 1}}, 4},
                {new int[][]{{0, 1, -1}, {1, 0, -1}, {1, -1, 1}}, 0},
                {new int[][]{{0, 1, -1}, {1, 1, -1}, {1, 1, 1}}, 6},
                {new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 8},
                {new int[][]{{1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1}}, 15},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.cherryPickup(grid);
        Assert.assertEquals(expected, result);
    }

}