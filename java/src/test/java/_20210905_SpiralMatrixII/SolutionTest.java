package _20210905_SpiralMatrixII;

import lombok.Value;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;

/**
 * @author koalayt 2021-09-05
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public TestCase testCase;

    @Parameters(name = "testcase:{index}")
    public static TestCase[] data() {
        return new TestCase[]{
                new TestCase(1, new int[][]{{1}}),
                new TestCase(2, new int[][]{
                        {1, 2},
                        {4, 3}}),
                new TestCase(3, new int[][]{
                        {1, 2, 3},
                        {8, 9, 4},
                        {7, 6, 5}}),
                new TestCase(4, new int[][]{
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7}}),
                new TestCase(5, new int[][]{
                        {1, 2, 3, 4, 5},
                        {16, 17, 18, 19, 6},
                        {15, 24, 25, 20, 7},
                        {14, 23, 22, 21, 8},
                        {13, 12, 11, 10, 9}}),
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[][] result = solution.generateMatrix(testCase.n);
        Assert.assertArrayEquals(Arrays.deepToString(result), testCase.expect, result);
    }

    @Value
    public static class TestCase {
        int n;
        int[][] expect;
    }

}