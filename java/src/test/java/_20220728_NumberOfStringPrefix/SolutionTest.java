package _20220728_NumberOfStringPrefix;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String[] s;

    @Parameterized.Parameter(1)
    public String a;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new String[]{"abc", "ab", "c"}, "ab", 2},
                {new String[]{"abc", "ab", "c"}, "ac", 0},
                {new String[]{"abc", "ab", "ab", "c"}, "a", 3},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.number_of_string_prefix(s, a);
        Assert.assertEquals(expected, result);
    }

}