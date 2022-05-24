package _20220524_NumberOfDiceRollsWithTargetSum;

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
    public int target;

    @Parameterized.Parameter(3)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {1, 6, 3, 1},
                {2, 6, 7, 6},
                {30, 30, 500, 222616187}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.numRollsToTarget(n, k, target);
        Assert.assertEquals(expected, result);
    }

}