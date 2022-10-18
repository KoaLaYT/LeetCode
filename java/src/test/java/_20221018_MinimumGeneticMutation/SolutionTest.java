package _20221018_MinimumGeneticMutation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String start;

    @Parameterized.Parameter(1)
    public String end;

    @Parameterized.Parameter(2)
    public String[] bank;

    @Parameterized.Parameter(3)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}, 1},
                {"AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}, 2},
                {"AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}, 3},
                {"AAAAACCC", "AACCCCCG", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}, -1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minMutation(start, end, bank);
        Assert.assertEquals(expected, result);
    }

}