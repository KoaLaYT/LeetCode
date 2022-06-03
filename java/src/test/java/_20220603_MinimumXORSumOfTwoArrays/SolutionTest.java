package _20220603_MinimumXORSumOfTwoArrays;

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
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2}, new int[]{2, 3}, 2},
                {new int[]{1, 0, 3}, new int[]{5, 3, 4}, 8},
                {
                        new int[]{65022, 4657711, 8572489, 3336640, 7744043, 8672352, 6861299, 5122697, 2857375, 7539481, 8907966, 3311170},
                        new int[]{6030101, 8828015, 59043, 6529065, 9719816, 7144904, 6799001, 5637315, 9805075, 1136584, 8266168, 4154565},
                        15088819
                },
                {
                        new int[]{100, 26, 12, 62, 3, 49, 55, 77, 97},
                        new int[]{98, 0, 89, 57, 34, 92, 29, 75, 13},
                        200
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minimumXORSum(nums1, nums2);
        Assert.assertEquals(expected, result);
    }

}