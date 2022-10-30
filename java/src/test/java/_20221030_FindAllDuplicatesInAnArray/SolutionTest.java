package _20221030_FindAllDuplicatesInAnArray;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] nums;

    @Parameterized.Parameter(1)
    public List<Integer> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{4, 3, 2, 7, 8, 2, 3, 1}, Arrays.asList(2, 3)},
                {new int[]{1, 1, 2}, Arrays.asList(1)},
                {new int[]{1}, Collections.emptyList()},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<Integer> result = solution.findDuplicates(nums);
        result.sort(Comparator.comparingInt(Integer::intValue));
        Assert.assertEquals(expected, result);
    }

}