package _20220508_ValidPalindromeIII;

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
    public int k;

    @Parameterized.Parameter(2)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"abcdeca", 2, true},
                {"abbababa", 1, true},
                {"a", 1, true},
                {"ab", 1, true},
                {"abc", 1, false},
                {"abc", 2, true},
                {"aa", 1, true},
                {"aba", 1, true},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.isValidPalindrome(s, k);
        Assert.assertEquals(expected, result);
    }

}