package _20210907_UniquePathsII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-09-08
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public int[][] obstacleGrid;

    @Parameter(1)
    public int expect;

    @Parameters(name = "testcase:{index}")
    public static Object[][] data() {
        return new Object[][]{
                {
                        new int[][]{
                                {0, 0, 0},
                                {0, 1, 0},
                                {0, 0, 0}},
                        2
                },
                {
                        new int[][]{
                                {0, 1},
                                {0, 0}},
                        1
                },
                {
                        new int[][]{
                                {0, 0},
                                {0, 1}},
                        0
                },
                {
                        new int[][]{
                                {0, 0},
                                {1, 1},
                                {0, 0}},
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
        int result = solution.uniquePathsWithObstacles(obstacleGrid);
        Assert.assertEquals(expect, result);
    }

}