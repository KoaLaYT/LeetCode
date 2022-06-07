package _20220607_FindLeftRepeatNum;

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
    public int[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 3, 1, 2, 1}, new int[]{-1, -1, 0, -1, 0}},
                {new int[]{}, new int[]{}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] result = solution.find_left_repeat_num(nums);
        Assert.assertArrayEquals(expected, result);
    }

}