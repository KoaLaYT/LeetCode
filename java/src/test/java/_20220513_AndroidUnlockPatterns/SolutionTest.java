package _20220513_AndroidUnlockPatterns;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int m;

    @Parameterized.Parameter(1)
    public int n;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {1, 1, 9},
                {1, 2, 65},
                {1, 3, 9 + 56 + 320},
                {2, 3, 56 + 320},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.numberOfPatterns(m, n);
        Assert.assertEquals(expected, result);
    }

}