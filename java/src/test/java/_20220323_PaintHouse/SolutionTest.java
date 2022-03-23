package _20220323_PaintHouse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] costs;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}, 10},
                {new int[][]{{7, 6, 2}}, 2}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minCost(costs);
        Assert.assertEquals(expected, result);
    }

}