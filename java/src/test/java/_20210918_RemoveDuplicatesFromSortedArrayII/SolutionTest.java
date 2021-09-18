package _20210918_RemoveDuplicatesFromSortedArrayII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;

/**
 * @author koalayt 2021-09-18
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public int[] nums;

    @Parameter(1)
    public int expectInt;

    @Parameter(2)
    public int[] expectNums;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        new int[]{1, 1, 1, 2, 2, 3},
                        5,
                        new int[]{1, 1, 2, 2, 3}
                },
                {
                        new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3},
                        7,
                        new int[]{0, 0, 1, 1, 2, 3, 3}
                },
                {
                        new int[]{1, 2, 3},
                        3,
                        new int[]{1, 2, 3}
                },
                {
                        new int[]{1, 1, 2, 2, 2, 3, 3, 3},
                        6,
                        new int[]{1, 1, 2, 2, 3, 3}
                },
                {
                        new int[]{0, 1, 1, 1, 1, 2, 2, 2},
                        5,
                        new int[]{0, 1, 1, 2, 2}
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.removeDuplicates(nums);
        Assert.assertEquals(Arrays.toString(nums), expectInt, result);
        for (int i = 0; i < expectInt; i++) {
            Assert.assertEquals(expectNums[i], nums[i]);
        }
    }

}