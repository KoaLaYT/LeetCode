package _20220514_KnightProbabilityInChessboard;

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
    public int k;

    @Parameterized.Parameter(2)
    public int row;

    @Parameterized.Parameter(3)
    public int column;

    @Parameterized.Parameter(4)
    public double expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {3, 2, 0, 0, 0.06250},
                {1, 0, 0, 0, 1.0},
                {3, 3, 0, 0, 0.015625},
                {3, 1, 1, 1, 0.0},
                {8, 30, 6, 4, 0.00019},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        double result = solution.knightProbability(n, k, row, column);
        Assert.assertEquals(expected, result, 0.000001);
    }

}