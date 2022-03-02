package _20220302_RepeatedSubstringPattern;

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
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"abab", true},
                {"aba", false},
                {"abcabcabcabc", true},
                {"acacac", true},
                {"acaca", false},
                {"ccc", true},
                {"a", false},
                {"abc", false},
                {"ababba", false},
        };
    }

    @Before
    public void setup() {
        this.solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.repeatedSubstringPattern(s);
        Assert.assertEquals(expected, result);
    }

}