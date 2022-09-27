package _20220927_EvaluateDivision;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public List<List<String>> equations;

    @Parameterized.Parameter(1)
    public double[] values;

    @Parameterized.Parameter(2)
    public List<List<String>> queries;

    @Parameterized.Parameter(3)
    public double[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")),
                        new double[]{2.0, 3.0},
                        Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")),
                        new double[]{6.0, 0.5, -1.0, 1.0, -1.0}
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        double[] result = solution.calcEquation(equations, values, queries);
        Assert.assertArrayEquals(expected, result, 0.00001);
    }

}