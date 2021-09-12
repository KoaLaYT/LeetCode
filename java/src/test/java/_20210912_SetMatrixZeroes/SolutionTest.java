package _20210912_SetMatrixZeroes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;

/**
 * @author koalayt 2021-09-12
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public int[][] matrix;

    @Parameter(1)
    public int[][] expect;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        new int[][]{
                                {1, 1, 1},
                                {1, 0, 1},
                                {1, 1, 1},
                        },
                        new int[][]{
                                {1, 0, 1},
                                {0, 0, 0},
                                {1, 0, 1},
                        },
                },
                {
                        new int[][]{
                                {0, 1, 2, 0},
                                {3, 4, 5, 2},
                                {1, 3, 1, 5},
                        },
                        new int[][]{
                                {0, 0, 0, 0},
                                {0, 4, 5, 0},
                                {0, 3, 1, 0},
                        },
                },
                {
                        new int[][]{
                                {1},
                                {0},
                        },
                        new int[][]{
                                {0},
                                {0},
                        },
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        solution.setZeroes(matrix);
        Assert.assertArrayEquals(Arrays.deepToString(matrix), expect, matrix);
    }

}