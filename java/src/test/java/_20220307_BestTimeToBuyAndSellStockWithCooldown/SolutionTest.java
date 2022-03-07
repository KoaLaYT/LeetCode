package _20220307_BestTimeToBuyAndSellStockWithCooldown;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tools.Utils;

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
                {new int[]{1, 2, 3, 0, 2}, 3},
                {new int[]{1}, 0},
                {Utils.readIntArrayFromFile("./BestTimeToBuyAndSellStockWithCooldown.txt"), 515062},
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