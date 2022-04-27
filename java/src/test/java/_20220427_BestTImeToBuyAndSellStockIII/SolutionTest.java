package _20220427_BestTImeToBuyAndSellStockIII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] prices;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{3, 3, 5, 0, 0, 3, 1, 4}, 6},
                {new int[]{1, 2, 3, 4, 5}, 4},
                {new int[]{7, 6, 4, 3, 1}, 0},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.maxProfit(prices);
        Assert.assertEquals(expected, result);
    }

}