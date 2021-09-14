package _20210914_MinimumWindowSubstring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-09-14
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public String s;

    @Parameter(1)
    public String t;

    @Parameter(2)
    public String expect;

    @Parameters
    public static String[][] data() {
        return new String[][]{
                {"ADOBECODEBANC", "ABC", "BANC"},
                {"ADOBECODEBANC", "ABBC", "BECODEBA"},
                {"ADOBECODEBANC", "AABBC", "ADOBECODEBA"},
                {"a", "a", "a"},
                {"a", "aa", ""},
                {"aa", "aa", "aa"},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        String result = solution.minWindow(s, t);
        Assert.assertEquals(expect, result);
    }

}