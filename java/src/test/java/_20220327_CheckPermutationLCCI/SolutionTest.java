package _20220327_CheckPermutationLCCI;

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
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"abc", "bca", true},
                {"abc", "bad", false},
                {"aab", "baa", true},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.CheckPermutation(s1, s2);
        Assert.assertEquals(expected, result);
    }

}