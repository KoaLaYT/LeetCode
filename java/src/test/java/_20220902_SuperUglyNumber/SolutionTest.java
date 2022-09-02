package _20220902_SuperUglyNumber;

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
    public int[] primes;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {12, new int[]{2, 7, 13, 19}, 32},
                {14, new int[]{2, 7, 13, 19}, 49},
                {1, new int[]{2, 3, 5}, 1},
                {15, new int[]{3, 5, 7, 11, 19, 23, 29, 41, 43, 47}, 35},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.nthSuperUglyNumber(n, primes);
        Assert.assertEquals(expected, result);
    }

}