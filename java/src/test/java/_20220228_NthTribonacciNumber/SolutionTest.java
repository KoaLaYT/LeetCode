package _20220228_NthTribonacciNumber;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public int n;

    @Parameter(1)
    public int expected;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 4},
                {25, 1389537},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.tribonacci(n);
        Assert.assertEquals(expected, result);
    }

}