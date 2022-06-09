package _20220609_NextPermutation;

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
                {new int[]{1, 2, 3}, new int[]{1, 3, 2}},
                {new int[]{3, 2, 1}, new int[]{1, 2, 3}},
                {new int[]{1, 1, 5}, new int[]{1, 5, 1}},
                {new int[]{1, 3, 2, 7, 6, 5}, new int[]{1, 3, 5, 2, 6, 7}},
                {new int[]{1, 3, 2, 7, 6, 5, 5}, new int[]{1, 3, 5, 2, 5, 6, 7}},
                {new int[]{1, 3, 2, 5, 5, 5}, new int[]{1, 3, 5, 2, 5, 5}},
                {new int[]{2, 3, 1}, new int[]{3, 1, 2}},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        Assert.assertArrayEquals(expected, nums);
    }

}