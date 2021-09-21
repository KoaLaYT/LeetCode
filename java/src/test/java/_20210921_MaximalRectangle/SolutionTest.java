package _20210921_MaximalRectangle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-09-21
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public char[][] matrix;

    @Parameter(1)
    public int expect;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        new char[][]{
                                {'1', '0', '1', '0', '0'},
                                {'1', '0', '1', '1', '1'},
                                {'1', '1', '1', '1', '1'},
                                {'1', '0', '0', '1', '0'},
                        },
                        6
                },
                {
                        new char[][]{},
                        0
                },
                {
                        new char[][]{
                                {'1'}
                        },
                        1
                },
                {
                        new char[][]{
                                {'0', '0'}
                        },
                        0
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.maximalRectangle(matrix);
        Assert.assertEquals(expect, result);
    }

}