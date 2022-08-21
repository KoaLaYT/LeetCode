package _20220821_RectangleArea;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int ax1;

    @Parameterized.Parameter(1)
    public int ay1;

    @Parameterized.Parameter(2)
    public int ax2;

    @Parameterized.Parameter(3)
    public int ay2;

    @Parameterized.Parameter(4)
    public int bx1;

    @Parameterized.Parameter(5)
    public int by1;

    @Parameterized.Parameter(6)
    public int bx2;

    @Parameterized.Parameter(7)
    public int by2;

    @Parameterized.Parameter(8)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {-3, 0, 3, 4, 0, -1, 9, 2, 45},
                {-2, -2, 2, 2, -2, -2, 2, 2, 16},
                {-2, -2, 2, 2, -4, -4, -3, -3, 17},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        Assert.assertEquals(expected, result);
    }
}