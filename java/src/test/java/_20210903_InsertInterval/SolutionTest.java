package _20210903_InsertInterval;

import lombok.Value;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;

/**
 * @author koalayt 2021-09-03
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public TestCase testCase;

    @Parameters(name = "testcase:{index}")
    public static TestCase[] data() {
        return new TestCase[]{
                new TestCase(
                        new int[][]{{1, 3}, {6, 9}},
                        new int[]{2, 5},
                        new int[][]{{1, 5}, {6, 9}}
                ),
                new TestCase(
                        new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                        new int[]{4, 8},
                        new int[][]{{1, 2}, {3, 10}, {12, 16}}
                ),
                new TestCase(
                        new int[][]{},
                        new int[]{5, 7},
                        new int[][]{{5, 7}}
                ),
                new TestCase(
                        new int[][]{{1, 5}},
                        new int[]{2, 3},
                        new int[][]{{1, 5}}
                ),
                new TestCase(
                        new int[][]{{1, 5}},
                        new int[]{2, 7},
                        new int[][]{{1, 7}}
                ),
                new TestCase(
                        new int[][]{{1, 5}},
                        new int[]{6, 8},
                        new int[][]{{1, 5}, {6, 8}}
                ),
                new TestCase(
                        new int[][]{{1, 2}, {3, 4}},
                        new int[]{6, 8},
                        new int[][]{{1, 2}, {3, 4}, {6, 8}}
                ),
                new TestCase(
                        new int[][]{{1, 5}},
                        new int[]{0, 3},
                        new int[][]{{0, 5}}
                ),
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[][] result = solution.insert(testCase.intervals, testCase.newInterval);
        Assert.assertArrayEquals(Arrays.deepToString(result), testCase.expect, result);
    }

    @Value
    public static class TestCase {
        int[][] intervals;
        int[] newInterval;
        int[][] expect;
    }

}