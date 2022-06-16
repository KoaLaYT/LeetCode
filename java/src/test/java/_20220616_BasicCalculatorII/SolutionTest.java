package _20220616_BasicCalculatorII;

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
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"3+2*2", 7},
                {"3/2", 1},
                {"3+5/2", 5},
                {"-23 + 40", 17},
                {"-1*3", -3},
                {"-1 + 2*3", 5},
                {"1*2-3/4+5*6-7*8+9/10", -24},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.calculate(s);
        Assert.assertEquals(expected, result);
    }

}