package _20220328_StringToURLLCCI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String S;

    @Parameterized.Parameter(1)
    public int length;

    @Parameterized.Parameter(2)
    public String expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Mr John Smith ", 13, "Mr%20John%20Smith"},
                {"          ", 5, "%20%20%20%20%20"},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        String result = solution.replaceSpaces(S, length);
        Assert.assertEquals(expected, result);
    }

}