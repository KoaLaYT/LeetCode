package _20210903_MergeIntervals;

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
                        new int[][]{{1, 9}, {2, 5}, {19, 20}, {10, 11}, {12, 20}, {0, 3}, {0, 1}, {0, 2}},
                        new int[][]{{0, 9}, {10, 11}, {12, 20}}),
                new TestCase(
                        new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                        new int[][]{{1, 6}, {8, 10}, {15, 18}})
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[][] result = solution.merge(testCase.intervals);
        Assert.assertArrayEquals(Arrays.deepToString(result), testCase.expect, result);
    }

    @Value
    public static class TestCase {
        int[][] intervals;
        int[][] expect;
    }

}