package _20220821_ContainsDuplicateIII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] nums;

    @Parameterized.Parameter(1)
    public int k;

    @Parameterized.Parameter(2)
    public int t;

    @Parameterized.Parameter(3)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3, 1}, 3, 0, true},
                {new int[]{1, 0, 1, 1}, 1, 2, true},
                {new int[]{1, 5, 9, 1, 5, 9}, 2, 3, false},
                {new int[]{1, 2, 2, 3, 4, 5}, 3, 0, true},
                {new int[]{1, 2, 2, 3, 4, 5}, 2, 0, true},
                {new int[]{-2147483648, 2147483647}, 1, 1, false},
                {new int[]{2147483646, 2147483647}, 3, 3, true},
                {new int[]{7, 1, 3}, 2, 3, true},
                {new int[]{0, 10, 22, 15, 0, 5, 22, 12, 1, 5}, 3, 3, false},
                {new int[]{1, 2, 2, 3, 1}, 3, 0, true}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.containsNearbyAlmostDuplicate(nums, k, t);
        Assert.assertEquals(expected, result);
    }

}