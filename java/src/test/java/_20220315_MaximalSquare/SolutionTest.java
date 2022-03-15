package _20220315_MaximalSquare;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public char[][] matrix;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}}, 4},
                {new char[][]{
                        {'0', '1'},
                        {'1', '0'}}, 1},
                {new char[][]{
                        {'0', '0', '0', '0', '0'},
                        {'0', '0', '1', '1', '1'},
                        {'0', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}}, 4},
                {new char[][]{
                        {'0', '0', '0', '0', '0'},
                        {'0', '0', '1', '1', '1'},
                        {'0', '1', '1', '1', '1'},
                        {'0', '0', '1', '1', '0'}}, 4},
                {new char[][]{
                        {'0', '0', '0', '0', '0'},
                        {'0', '0', '1', '1', '1'},
                        {'0', '1', '1', '1', '1'},
                        {'0', '0', '0', '1', '1'}}, 4},
                {new char[][]{
                        {'0', '0', '0', '0', '0'},
                        {'0', '0', '1', '1', '1'},
                        {'0', '1', '1', '1', '1'},
                        {'0', '0', '1', '1', '1'}}, 9},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.maximalSquare(matrix);
        Assert.assertEquals(expected, result);
    }

}