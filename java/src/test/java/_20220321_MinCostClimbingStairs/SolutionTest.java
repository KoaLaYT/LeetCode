package _20220321_MinCostClimbingStairs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] cost;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{10, 15, 20}, 15},
                {new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minCostClimbingStairs(cost);
        Assert.assertEquals(expected, result);
    }

}