package _20220324_BestTimeToBuyAndSellStockWithTransactionFee;

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
    public int fee;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 3, 2, 8, 4, 9}, 2, 8},
                {new int[]{1, 3, 7, 5, 10, 3}, 3, 6},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.maxProfit(prices, fee);
        Assert.assertEquals(expected, result);
    }

}