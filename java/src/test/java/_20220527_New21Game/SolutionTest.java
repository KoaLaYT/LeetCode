package _20220527_New21Game;

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
    public int k;

    @Parameterized.Parameter(2)
    public int maxPts;

    @Parameterized.Parameter(3)
    public double expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {10, 1, 10, 1.0},
                {6, 1, 10, 0.6},
                {21, 17, 10, 0.73278},
                {0, 0, 1, 1.0}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        double result = solution.new21Game(n, k, maxPts);
        Assert.assertEquals(expected, result, 0.00001);
    }

}