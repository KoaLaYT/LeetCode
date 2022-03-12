package _20220312_MinimumFallingPathSum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] matrix;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{
                        {2, 1, 3},
                        {6, 5, 4},
                        {7, 8, 9}}, 13},
                {new int[][]{
                        {-19, 57}, {-40, -5}}, -59},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minFallingPathSum(matrix);
        Assert.assertEquals(expected, result);
    }

}