package _20220528_MinimumCostToCutAStick;

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
    public int[] cuts;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {7, new int[]{1, 3, 4, 5}, 16},
                {9, new int[]{5, 6, 1, 4, 2}, 22},
                {7249, new int[]{2542, 5776, 4306, 1787, 1536, 2520, 2558, 4289, 2390, 1371, 2526, 256, 3025, 1752, 1780, 2652, 4815, 5689, 2719, 7034, 7058, 1431, 5086, 1137, 481, 3977, 1047, 899, 3915, 1615, 4996, 5317, 5330, 3010, 6987, 2633, 4396, 6006, 687, 4870, 434, 4876, 3067, 4006, 2043, 2519, 2881, 2083, 3784, 6733, 3129, 6723, 5936, 3139, 908, 226}, 38626},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minCost(n, cuts);
        Assert.assertEquals(expected, result);
    }

}