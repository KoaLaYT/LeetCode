package _20210912_SearchA2DMatrix;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-09-12
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public int[][] matrix;

    @Parameter(1)
    public int target;

    @Parameter(2)
    public boolean expect;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        new int[][]{
                                {1, 3, 5, 7},
                                {10, 11, 16, 20},
                                {23, 30, 34, 60},
                        },
                        3,
                        true,
                },
                {
                        new int[][]{
                                {1, 3, 5, 7},
                                {10, 11, 16, 20},
                                {23, 30, 34, 60},
                        },
                        6,
                        false,
                },
                {
                        new int[][]{
                                {1, 3, 5, 7},
                                {10, 11, 16, 20},
                                {23, 30, 34, 60},
                        },
                        16,
                        true,
                },
                {
                        new int[][]{
                                {1, 3, 5, 7},
                                {10, 11, 16, 20},
                                {23, 30, 34, 60},
                        },
                        13,
                        false,
                },
                {
                        new int[][]{
                                {1, 3, 5, 7},
                                {10, 11, 16, 20},
                                {23, 30, 34, 60},
                        },
                        60,
                        true,
                },
                {
                        new int[][]{
                                {1, 3, 5, 7},
                                {10, 11, 16, 20},
                                {23, 30, 34, 60},
                        },
                        31,
                        false,
                },
                {
                        new int[][]{
                                {1, 3, 5, 7},
                                {10, 11, 16, 20},
                                {23, 30, 34, 60},
                        },
                        77,
                        false,
                },
                {
                        new int[][]{
                                {1, 3, 5, 7},
                                {10, 11, 16, 20},
                                {23, 30, 34, 60},
                        },
                        0,
                        false,
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.searchMatrix(matrix, target);
        Assert.assertEquals(expect, result);
    }

}