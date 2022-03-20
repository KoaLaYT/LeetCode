package _20220320_CoinChangeII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int amount;

    @Parameterized.Parameter(1)
    public int[] coins;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {5, new int[]{1, 2, 5}, 4},
                {3, new int[]{2}, 0},
                {10, new int[]{10}, 1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.change(amount, coins);
        Assert.assertEquals(expected, result);
    }

}