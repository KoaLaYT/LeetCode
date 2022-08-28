package _20220828_AdditiveNumber;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String num;

    @Parameterized.Parameter(1)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"112358", true},
                {"199100199", true},
                {"2001201202", true},
                {"2001201203", false},
                {"101", true},
                {"10112", true},
                {"10", false},
                {"000", true},
                {"121474836472147483648", true},
                {"11111111111011111111111", true},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.isAdditiveNumber(num);
        Assert.assertEquals(expected, result);
    }

}