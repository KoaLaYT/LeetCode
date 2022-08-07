package _20220807_MinimumCost;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int n;

    @Parameterized.Parameter(1)
    public int[][] connections;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}, 6},
                {4, new int[][]{{1, 2, 3}, {3, 4, 4}}, -1},
                {8, new int[][]{{5, 7, 1}, {3, 6, 1}, {2, 3, 2}, {3, 5, 2}, {1, 3, 3}, {2, 7, 4}, {1, 2, 6}, {2, 4, 7}, {6, 8, 8}, {3, 8, 10}}, 24},
                {8, new int[][]{{5, 7, 1}, {3, 6, 1}, {2, 3, 2}, {3, 5, 2}, {1, 3, 3}, {2, 7, 4}, {1, 2, 6}, {6, 8, 8}, {3, 8, 10}}, -1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minimumCost(n, connections);
        Assert.assertEquals(expected, result);
    }

}