package _20220813_PalindromePartitioning;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String s;

    @Parameterized.Parameter(1)
    public List<List<String>> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        "aab",
                        Arrays.asList(
                                Arrays.asList("a", "a", "b"),
                                Arrays.asList("aa", "b")
                        )
                },
                {
                        "abaa",
                        Arrays.asList(
                                Arrays.asList("a", "b", "aa"),
                                Arrays.asList("a", "b", "a", "a"),
                                Arrays.asList("aba", "a")
                        )
                },
                {
                        "a",
                        Arrays.asList(Arrays.asList("a"))
                },
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<List<String>> result = solution.partition(s);
        result.sort(Comparator.comparingInt(List::size));
        expected.sort(Comparator.comparingInt(List::size));
        Assert.assertEquals(expected, result);
    }

}