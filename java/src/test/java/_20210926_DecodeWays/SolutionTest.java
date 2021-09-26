package _20210926_DecodeWays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-09-26
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public String s;

    @Parameter(1)
    public int expect;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"12", 2},
                {"226", 3},
                {"0", 0},
                {"06", 0},
                {"107", 1},
                {"277", 1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.numDecodings(s);
        Assert.assertEquals(expect, result);
    }

}