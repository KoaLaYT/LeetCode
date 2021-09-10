package _20210910_PlusOne;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;

/**
 * @author koalayt 2021-09-10
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public int[] digits;

    @Parameter(1)
    public int[] expect;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        new int[]{1, 2, 3},
                        new int[]{1, 2, 4},
                },
                {
                        new int[]{4, 3, 2, 1},
                        new int[]{4, 3, 2, 2},
                },
                {
                        new int[]{0},
                        new int[]{1},
                },
                {
                        new int[]{9},
                        new int[]{1, 0},
                },
                {
                        new int[]{9, 9},
                        new int[]{1, 0, 0},
                },
                {
                        new int[]{9, 9, 9, 9},
                        new int[]{1, 0, 0, 0, 0},
                },
                {
                        new int[]{1, 0, 0, 9},
                        new int[]{1, 0, 1, 0},
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] result = solution.plusOne(digits);
        Assert.assertArrayEquals(Arrays.toString(result), expect, result);
    }

}