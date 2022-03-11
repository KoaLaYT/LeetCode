package _20220311_RotateImage;

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
    public int[][] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                }, new int[][]{
                        {7, 4, 1},
                        {8, 5, 2},
                        {9, 6, 3},
                }},
                {new int[][]{
                        {5, 1, 9, 11},
                        {2, 4, 8, 10},
                        {13, 3, 6, 7},
                        {15, 14, 12, 16},
                }, new int[][]{
                        {15, 13, 2, 5},
                        {14, 3, 4, 1},
                        {12, 6, 8, 9},
                        {16, 7, 10, 11},
                }},
                {new int[][]{
                        {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25},
                }, new int[][]{
                        {21, 16, 11, 6, 1},
                        {22, 17, 12, 7, 2},
                        {23, 18, 13, 8, 3},
                        {24, 19, 14, 9, 4},
                        {25, 20, 15, 10, 5},
                }},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        print(matrix, "before");
        solution.rotate(matrix);
        print(matrix, "after");
        print(expected, "expected");
        Assert.assertEquals(expected, matrix);
    }

    private void print(int[][] matrix, String banner) {
        int n = matrix.length;
        System.out.println(banner);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%02d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}