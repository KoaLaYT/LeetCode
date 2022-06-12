package _20220612_SortedAray3Sum;

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
    public int target;

    @Parameterized.Parameter(2)
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{2, 7, 11, 15}, 20, new int[]{0, 1, 2}},
                {new int[]{2, 7, 11, 15}, 28, new int[]{0, 2, 3}},
                {new int[]{2, 7, 11, 15}, 33, new int[]{1, 2, 3}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] result = solution.sortedArray3Sum(nums, target);
        Assert.assertArrayEquals(expected, result);
    }

}