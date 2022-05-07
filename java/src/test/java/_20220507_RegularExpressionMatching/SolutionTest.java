package _20220507_RegularExpressionMatching;

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
    public String p;

    @Parameterized.Parameter(2)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"aa", "a", false},
                {"aa", "a*", true},
                {"ab", ".*", true},
                {"ab", ".*a", false},
                {"", ".", false},
                {"", ".*", true},
                {"", "", true},
                {"a", "", false},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.isMatch(s, p);
        Assert.assertEquals(expected, result);
    }

}