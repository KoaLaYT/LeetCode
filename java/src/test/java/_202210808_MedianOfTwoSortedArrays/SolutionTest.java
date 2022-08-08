package _202210808_MedianOfTwoSortedArrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] nums1;

    @Parameterized.Parameter(1)
    public int[] nums2;

    @Parameterized.Parameter(2)
    public double expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 3}, new int[]{2}, 2},
                {new int[]{1, 2}, new int[]{3, 4}, 2.5},
                {new int[]{1, 2, 3, 4}, new int[]{5}, 3},
                {new int[]{1, 2, 3, 4}, new int[]{5, 6}, 3.5},
                {new int[]{0, 0}, new int[]{0, 0}, 0},
                {new int[]{3}, new int[]{-2, -1}, -1},
                {new int[]{1, 2}, new int[]{-1, 3}, 1.5},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        double result = solution.findMedianSortedArrays(nums1, nums2);
        Assert.assertEquals(expected, result, 1e-6);
    }

}