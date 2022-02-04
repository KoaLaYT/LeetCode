package _20220204_HouseRobber;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public int[] nums;

    @Parameter(1)
    public int expect;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 1}, 4},
                {new int[]{2, 7, 9, 3, 1}, 12},
                {new int[]{}, 0},
                {new int[]{1}, 1},
                {new int[]{1, 2}, 2},
                {new int[]{2, 1, 1, 2}, 4},
                {new int[]{3, 1, 1, 1, 1, 3}, 7},
                {new int[]{2, 11, 2}, 11},
                {new int[]{1, 1, 1}, 2},
                {new int[]{4, 1, 2, 7, 5, 3, 1}, 14},
                {new int[]{183, 219, 57, 193, 94, 233, 202, 154, 65, 240, 97, 234, 100, 249, 186, 66, 90, 238, 168, 128, 177, 235, 50, 81, 185, 165, 217, 207, 88, 80, 112, 78, 135, 62, 228, 247, 211}, 3365}
        });
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.rob(nums);
        Assert.assertEquals(expect, result);
    }

}