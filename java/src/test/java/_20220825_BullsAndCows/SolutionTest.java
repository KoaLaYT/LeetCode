package _20220825_BullsAndCows;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String secret;

    @Parameterized.Parameter(1)
    public String guess;

    @Parameterized.Parameter(2)
    public String expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"1807", "7810", "1A3B"},
                {"1123", "0111", "1A1B"},
                {"21123", "10111", "1A1B"},
                {"21123", "10123", "3A1B"},
                {"011", "110", "1A2B"},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        String result = solution.getHint(secret, guess);
        Assert.assertEquals(expected, result);
    }

}