package _20220924_UTF8Validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] data;

    @Parameterized.Parameter(1)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{197, 130, 1}, true},
                {new int[]{235, 140, 4}, false},
                {new int[]{255}, false},
                {new int[]{237}, false},
                {new int[]{230, 136, 145}, true}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.validUtf8(data);
        Assert.assertEquals(expected, result);
    }

}