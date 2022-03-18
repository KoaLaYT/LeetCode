package _20220318_IsSubsequence;

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
    public String t;

    @Parameterized.Parameter(2)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"abc", "ahbgdc", true},
                {"axc", "ahbgdc", false},
                {"abc", "abbbc", true},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.isSubsequence(s, t);
        Assert.assertEquals(expected, result);
    }

}