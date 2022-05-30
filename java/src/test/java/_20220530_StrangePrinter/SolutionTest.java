package _20220530_StrangePrinter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String s;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"aaabbb", 2},
                {"aba", 2},
                {"acbaab", 4},
                {"abacababacab", 7},
                {"dddccbdbababaddcbcaabdbdddcccddbbaabddb", 15},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.strangePrinter(s);
        Assert.assertEquals(expected, result);
    }

}