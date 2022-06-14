package _20220614_BasicCalculator;

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
                {"1+1", 2},
                {"2-1 + 2", 3},
                {"(1+(4+5+2)-3)+(6+8)", 23},
                {"1-(-1+3)", -1},
                {"-23 + 40", 17},
                {"-(23+40)", -63},
                {"1+(1+(1+(-2+30)))", 31},
                {"(40) + (-32)", 8},
                {"- (3 + (4 + 5))", -12},
                {"-(3+4)+5", -2},
                {"- (3 - (- (4 + 5) ) )", -12},
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