package _20220915_WaterAndJugProblem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int jug1Capacity;

    @Parameterized.Parameter(1)
    public int jug2Capacity;

    @Parameterized.Parameter(2)
    public int targetCapacity;

    @Parameterized.Parameter(3)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {3, 5, 4, true},
                {2, 6, 5, false},
                {1, 2, 3, true}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity);
        Assert.assertEquals(expected, result);
    }

}