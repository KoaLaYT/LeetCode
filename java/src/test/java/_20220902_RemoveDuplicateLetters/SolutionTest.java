package _20220902_RemoveDuplicateLetters;

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
    public String expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"bcabc", "abc"},
                {"cbacdcbc", "acdb"},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        String result = solution.removeDuplicateLetters(s);
        Assert.assertEquals(expected, result);
    }

}