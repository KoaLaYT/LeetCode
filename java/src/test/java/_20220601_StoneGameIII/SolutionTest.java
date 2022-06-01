package _20220601_StoneGameIII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[] stoneValue;

    @Parameterized.Parameter(1)
    public String expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3, 7}, "Bob"},
                {new int[]{1, 2, 3, -9}, "Alice"},
                {new int[]{1, 2, 3, 6}, "Tie"},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        String result = solution.stoneGameIII(stoneValue);
        Assert.assertEquals(expected, result);
    }

}