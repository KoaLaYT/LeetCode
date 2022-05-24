package _20220524_NumberOfWaysToStayInTheSamePlaceAfterSomeSteps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int steps;

    @Parameterized.Parameter(1)
    public int arrLen;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {3, 2, 4},
                {2, 4, 2},
                {4, 2, 8},
                {27, 7, 127784505},
                {430, 148488, 525833932},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.numWays(steps, arrLen);
        Assert.assertEquals(expected, result);
    }

}