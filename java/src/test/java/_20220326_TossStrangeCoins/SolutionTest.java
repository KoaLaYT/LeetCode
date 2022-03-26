package _20220326_TossStrangeCoins;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public double[] prob;

    @Parameterized.Parameter(1)
    public int target;

    @Parameterized.Parameter(2)
    public double expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new double[]{0.4}, 1, 0.4},
                {new double[]{0.4}, 0, 0.6},
                {new double[]{0.5, 0.5, 0.5, 0.5, 0.5}, 0, 0.03125},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        double result = solution.probabilityOfHeads(prob, target);
        Assert.assertEquals(expected, result, 0.00001);
    }

}