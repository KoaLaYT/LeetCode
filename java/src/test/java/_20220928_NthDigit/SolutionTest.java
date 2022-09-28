package _20220928_NthDigit;

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
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {3, 3},
                {10, 1},
                {11, 0},
                {190, 1},
                {3000, 2},
                {Integer.MAX_VALUE, 2},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.findNthDigit(n);
        Assert.assertEquals(expected, result);
    }

}