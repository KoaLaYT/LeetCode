package _20220314_NextGreaterElementII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

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
                {new int[]{1, 2, 1}, new int[]{2, -1, 2}},
                {new int[]{1, 2, 3, 4, 3}, new int[]{2, 3, 4, -1, 4}},
                {new int[]{1, 2, 4, 4, 3}, new int[]{2, 4, -1, -1, 4}},
                {new int[]{1, -1, 523, 43, 3, 477, 6, 3, 423, 5645, 63, 12},
                        new int[]{523, 523, 5645, 477, 477, 5645, 423, 423, 5645, -1, 523, 523}},
                {new int[]{1, 1, 1, 1, 1}, new int[]{-1, -1, -1, -1, -1}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] result = solution.nextGreaterElements(nums);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("result:   " + Arrays.toString(result));
        Assert.assertArrayEquals(expected, result);
    }

}