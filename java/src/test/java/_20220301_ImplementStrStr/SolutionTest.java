package _20220301_ImplementStrStr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String haystack;

    @Parameterized.Parameter(1)
    public String needle;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"hello", "ll", 2},
                {"aaaaa", "bba", -1},
                {"", "", 0},
        };
    }

    @Before
    public void setup() {
        this.solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.strStr(haystack, needle);
        Assert.assertEquals(expected, result);
    }

}