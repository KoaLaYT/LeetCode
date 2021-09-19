package _20210919_SearchInRotatedSortedArrayII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-09-19
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public int[] nums;

    @Parameter(1)
    public int target;

    @Parameter(2)
    public boolean expect;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        new int[]{2, 5, 6, 0, 0, 1, 2},
                        0,
                        true
                },
                {
                        new int[]{2, 5, 6, 0, 0, 1, 2},
                        3,
                        false
                },
                {
                        new int[]{2, 5, 6, 0, 0, 1, 2},
                        7,
                        false
                },
                {
                        new int[]{1, 2, 3, 4, 5, 6},
                        6,
                        true
                },
                {
                        new int[]{1, 2, 3, 4, 5, 6},
                        7,
                        false,
                },
                {
                        new int[]{1, 2, 3, 4, 5, 6},
                        1,
                        true,
                },
                {
                        new int[]{1, 2, 3, 4, 5, 6},
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
        boolean result = solution.search(nums, target);
        Assert.assertEquals(expect, result);
    }

}