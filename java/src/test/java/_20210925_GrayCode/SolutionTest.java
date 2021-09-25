package _20210925_GrayCode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author koalayt 2021-09-25
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public int n;

    @Parameter(1)
    public List<Integer> expect;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {1, Arrays.asList(0, 1)},
                {2, Arrays.asList(0, 1, 3, 2)},
                {3, Arrays.asList(0, 1, 3, 2, 6, 7, 5, 4)},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<Integer> result = solution.grayCode(n);
        Assert.assertArrayEquals(expect.toArray(), result.toArray());
    }

}