package _20220821_CombinationSumIII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int k;

    @Parameterized.Parameter(1)
    public int n;

    @Parameterized.Parameter(2)
    public List<List<Integer>> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {3, 7, Arrays.asList(Arrays.asList(1, 2, 4))},
                {3, 9, Arrays.asList(Arrays.asList(1, 2, 6), Arrays.asList(1, 3, 5), Arrays.asList(2, 3, 4))},
                {4, 1, Arrays.asList()},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<List<Integer>> result = solution.combinationSum3(k, n);
        Assert.assertEquals(expected, result);
    }

}