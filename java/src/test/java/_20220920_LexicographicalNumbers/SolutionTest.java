package _20220920_LexicographicalNumbers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int n;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {13}, {2}, {121}, {5000}, {1}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<Integer> result = solution.lexicalOrder(n);
        List<Integer> expected = buildExpected(n);
        Assert.assertEquals(expected, result);
    }

    private static List<Integer> buildExpected(int n) {
        List<Integer> result = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            result.add(i);
        }
        result.sort(Comparator.comparing(String::valueOf));
        return result;
    }

}