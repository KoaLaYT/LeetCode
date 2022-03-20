package _20220320_CoinChange;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] coins;

    @Parameterized.Parameter(1)
    public int amount;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 5}, 11, 3},
                {new int[]{2}, 3, -1},
                {new int[]{1}, 0, 0},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.coinChange(coins, amount);
        Assert.assertEquals(expected, result);
    }

}