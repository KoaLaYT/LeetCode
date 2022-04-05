package _20220405_LongestLineOfConsecutiveOneInMatrix;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] mat;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}}, 3},
                {new int[][]{{1, 1, 1, 1}, {0, 1, 1, 0}, {0, 0, 0, 1}}, 4},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.longestLine(mat);
        Assert.assertEquals(expected, result);
    }

}