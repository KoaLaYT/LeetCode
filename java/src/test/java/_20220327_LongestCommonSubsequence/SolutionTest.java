package _20220327_LongestCommonSubsequence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String text1;

    @Parameterized.Parameter(1)
    public String text2;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"abcde", "ace", 3},
                {"abc", "abc", 3},
                {"abc", "def", 0},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.longestCommonSubsequence(text1, text2);
        Assert.assertEquals(expected, result);
    }

}