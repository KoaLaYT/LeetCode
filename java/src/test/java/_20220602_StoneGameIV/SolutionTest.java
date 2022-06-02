package _20220602_StoneGameIV;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int n;

    @Parameterized.Parameter(1)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {1, true},
                {2, false},
                {3, true},
                {4, true},
                {5, false},
                {6, true},
                {9, true},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.winnerSquareGame(n);
        Assert.assertEquals(expected, result);
    }

}