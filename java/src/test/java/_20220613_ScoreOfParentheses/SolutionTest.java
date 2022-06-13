package _20220613_ScoreOfParentheses;

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
                {"()", 1},
                {"(())", 2},
                {"()()", 2},
                {"(()(()))", 6},
                {"((()))()", 5},
                {"((()))()(())", 7},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.scoreOfParentheses(s);
        Assert.assertEquals(expected, result);
    }

}