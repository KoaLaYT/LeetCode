package _20220330_MaximumLengthOfPairChain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] pairs;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{1, 2}, {7, 8}, {4, 5}}, 3},
                {new int[][]{{1, 2}, {2, 3}, {3, 4}}, 2},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.findLongestChain(pairs);
        Assert.assertEquals(expected, result);
    }

}