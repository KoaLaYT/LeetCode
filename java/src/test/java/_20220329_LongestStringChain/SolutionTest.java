package _20220329_LongestStringChain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String[] words;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}, 5},
                {new String[]{"a", "b", "ba", "bca", "bda", "bdca"}, 4},
                {new String[]{"abcd", "dbqca"}, 1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.longestStrChain(words);
        Assert.assertEquals(expected, result);
    }

}