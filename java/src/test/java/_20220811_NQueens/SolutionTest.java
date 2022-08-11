package _20220811_NQueens;

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
    public int n;

    @Parameterized.Parameter(1)
    public List<List<String>> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {1, Arrays.asList(Arrays.asList("Q"))},
                {4, Arrays.asList(
                        Arrays.asList(
                                ".Q..",
                                "...Q",
                                "Q...",
                                "..Q."),
                        Arrays.asList(
                                "..Q.",
                                "Q...",
                                "...Q",
                                ".Q..")
                )},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<List<String>> result = solution.solveNQueens(n);
        Assert.assertEquals(expected, result);
    }

}