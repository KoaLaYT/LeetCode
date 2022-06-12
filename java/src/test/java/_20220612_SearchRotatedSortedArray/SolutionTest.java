package _20220612_SearchRotatedSortedArray;

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
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4},
                {new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1},
                {new int[]{4, 5, 6, 7, 0, 1, 2}, 5, 1},
                {new int[]{4, 5, 6, 7, 0, 1, 2}, 1, 5},
                {new int[]{4, 5, 6, 7, 0, 1, 2}, 4, 0},
                {new int[]{4, 5, 6, 7, 0, 1, 2}, 2, 6},
                {new int[]{4, 5, 6, 7, 0, 1, 2}, 6, 2},
                {new int[]{4, 5, 6, 7, 0, 1, 2}, 7, 3},
                {new int[]{4, 5, 6, 7, 0, 1, 2}, 8, -1},
                {new int[]{4, 5, 6, 0, 1, 2}, 4, 0},
                {new int[]{4, 5, 6, 0, 1, 2}, 5, 1},
                {new int[]{4, 5, 6, 0, 1, 2}, 6, 2},
                {new int[]{4, 5, 6, 0, 1, 2}, 0, 3},
                {new int[]{4, 5, 6, 0, 1, 2}, 1, 4},
                {new int[]{4, 5, 6, 0, 1, 2}, 2, 5},
                {new int[]{4, 5, 6, 0, 1, 2}, 3, -1},
                {new int[]{4, 5, 6, 0, 1, 2}, 7, -1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.search(nums, target);
        Assert.assertEquals(expected, result);
    }

}