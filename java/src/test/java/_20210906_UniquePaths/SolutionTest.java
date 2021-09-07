package _20210906_UniquePaths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-09-06
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public int m;

    @Parameter(1)
    public int n;

    @Parameter(2)
    public int expect;

    @Parameters(name = "testcase:{index} -- {0}x{1} ==> {2}")
    public static Object[][] data() {
        return new Object[][]{
                {3, 7, 28},
                {3, 2, 3},
                {7, 3, 28},
                {3, 3, 6},
                {4, 2, 4},
                {4, 3, 10},
                {4, 4, 20},
                {23, 12, 193536720}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.uniquePaths(m, n);
        Assert.assertEquals(expect, result);
    }

}