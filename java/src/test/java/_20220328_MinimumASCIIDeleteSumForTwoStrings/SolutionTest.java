package _20220328_MinimumASCIIDeleteSumForTwoStrings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String s1;

    @Parameterized.Parameter(1)
    public String s2;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"sea", "eat", 231},
                {"delete", "leet", 403},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minimumDeleteSum(s1, s2);
        Assert.assertEquals(expected, result);
    }
}