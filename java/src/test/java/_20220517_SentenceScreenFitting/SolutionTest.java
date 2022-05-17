package _20220517_SentenceScreenFitting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String[] sentence;

    @Parameterized.Parameter(1)
    public int rows;

    @Parameterized.Parameter(2)
    public int cols;

    @Parameterized.Parameter(3)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new String[]{"hello", "world"}, 2, 8, 1},
                {new String[]{"hello", "world"}, 1, 8, 0},
                {new String[]{"hello", "world"}, 2, 4, 0},
                {new String[]{"hello", "world"}, 2, 5, 1},
                {new String[]{"a", "bcd", "e"}, 3, 6, 2},
                {new String[]{"i", "had", "apple", "pie"}, 4, 5, 1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.wordsTyping(sentence, rows, cols);
        Assert.assertEquals(expected, result);
    }

}