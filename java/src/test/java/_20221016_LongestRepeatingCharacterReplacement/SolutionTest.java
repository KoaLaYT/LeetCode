package _20221016_LongestRepeatingCharacterReplacement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String s;

    @Parameterized.Parameter(1)
    public int k;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"ABAB", 2, 4},
                {"AABABBA", 1, 4},
                {"XXY", 1, 3},
                {"XXY", 0, 2},
                {"A", 0, 1},
                {"A", 1, 1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.characterReplacement(s, k);
        Assert.assertEquals(expected, result);
    }

}