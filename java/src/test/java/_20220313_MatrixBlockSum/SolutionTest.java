package _20220313_MatrixBlockSum;

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
    public int k;

    @Parameterized.Parameter(2)
    public int[][] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1,
                        new int[][]{{12, 21, 16}, {27, 45, 33}, {24, 39, 28}}},
                {new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2,
                        new int[][]{{45, 45, 45}, {45, 45, 45}, {45, 45, 45}}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[][] result = solution.matrixBlockSum(mat, k);
        Assert.assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(expected[i], result[i]);
        }
    }

}