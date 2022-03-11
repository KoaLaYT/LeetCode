package _20220311_PascalsTriangle;

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
    public int numRows;

    @Parameterized.Parameter(1)
    public List<List<Integer>> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {5, Arrays.asList(Arrays.asList(1),
                        Arrays.asList(1, 1),
                        Arrays.asList(1, 2, 1),
                        Arrays.asList(1, 3, 3, 1),
                        Arrays.asList(1, 4, 6, 4, 1))},
                {1, Arrays.asList(Arrays.asList(1))},
        };
    }

    @Before
    public void setup() {
        this.solution = new Solution();
    }

    @Test
    public void test() {
        List<List<Integer>> result = solution.generate(numRows);
        Assert.assertEquals(expected, result);
    }

}