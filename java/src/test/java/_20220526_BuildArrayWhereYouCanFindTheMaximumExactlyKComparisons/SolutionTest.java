package _20220526_BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int n;

    @Parameterized.Parameter(1)
    public int m;

    @Parameterized.Parameter(2)
    public int k;

    @Parameterized.Parameter(3)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {2, 3, 1, 6},
                {5, 2, 3, 0},
                {9, 1, 1, 1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.numOfArrays(n, m, k);
        Assert.assertEquals(expected, result);
    }

}