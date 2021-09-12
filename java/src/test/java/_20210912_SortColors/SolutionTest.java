package _20210912_SortColors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;

/**
 * @author koalayt 2021-09-12
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public int[] nums;

    @Parameters
    public static int[][] data() {
        return new int[][]{
                {2, 0, 2, 1, 1, 0},
                {2, 0, 1},
                {2, 1, 0, 2},
                {0},
                {1},
                {2, 1, 1, 2},
                {2, 2, 2, 2},
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 0, 1, 1, 2, 2},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        solution.sortColors(nums);
        Assert.assertTrue(Arrays.toString(nums), isSorted(nums));
    }

    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

}