package _20220316_LongestPalindromicSubstring;

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
                {"babad", "bab"},
                {"cbbd", "bb"},
                {"cbbdc", "bb"},
                {"ccccc", "ccccc"},
                {"c", "c"},
                {"abc", "a"},
                {"aaaa", "aaaa"},
                {"aacabdkacaa", "aca"},
                {"123abacba133", "aba"},
                {"123abcba133", "abcba"},
                {"abcba", "abcba"},
                {"dbabcd", "bab"},
                {"cbbd", "bb"},
                {"a", "a"},
                {"ac", "a"},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        String result = solution.longestPalindrome(s);
        Assert.assertEquals(expected, result);
    }

}