package _20220917_KthSmallestElementInASortedMatrix;

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
    public int k;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15},
                }, 8, 13},
                {new int[][]{
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15},
                }, 7, 13},
                {new int[][]{
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15},
                }, 9, 15},
                {new int[][]{
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15},
                }, 1, 1},
                {new int[][]{{-5}}, 1, -5},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.kthSmallest(matrix, k);
        Assert.assertEquals(expected, result);
    }

}