package _20221106_StringCompression;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public char[] chars;

    @Parameterized.Parameter(1)
    public char[] expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'},
                        new char[]{'a', '2', 'b', '2', 'c', '3'}
                },
                {
                        new char[]{'a'},
                        new char[]{'a'}
                },
                {
                        new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'},
                        new char[]{'a', 'b', '1', '2'}
                },
                {
                        new char[]{'a', 'b', 'a'},
                        new char[]{'a', 'b', 'a'},
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.compress(chars);
        Assert.assertEquals(expected.length, result);
        for (int i = 0; i < result; i++) {
            Assert.assertEquals(expected[i], chars[i]);
        }
    }

}