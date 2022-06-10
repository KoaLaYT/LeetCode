package _20220610_MaxProductII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public double[] nums;

    @Parameterized.Parameter(1)
    public double expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new double[]{8, 32, 0.5, 0.03125}, 256.0},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        double result = solution.maxProductII(nums);
        Assert.assertEquals(expected, result, 0.00001);
    }

}