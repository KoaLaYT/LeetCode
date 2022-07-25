package _20220725_MyPow;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private static final double DELTA = 0.000001;

    private Solution solution;

    @Parameterized.Parameter
    public double x;

    @Parameterized.Parameter(1)
    public int n;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {2.0, 10},
                {2.1, 3},
                {2.0, -2},
                {1.0, -2147483648},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        double result = solution.myPow(x, n);
        Assert.assertEquals(Math.pow(x, n), result, DELTA);
    }

}