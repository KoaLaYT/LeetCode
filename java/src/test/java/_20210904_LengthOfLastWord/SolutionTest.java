package _20210904_LengthOfLastWord;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-09-04
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public String s;

    @Parameter(1)
    public int expect;

    @Parameters(name = "testcase{index}: {0}")
    public static Object[][] data() {
        return new Object[][]{
                {"Hello World", 5},
                {"   fly me   to   the moon  ", 4},
                {"luffy is still joyboy", 6},
                {"a", 1},
                {"Today is a nice day", 3},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.lengthOfLastWord(s);
        Assert.assertEquals(expect, result);
    }

}