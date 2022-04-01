package _20220401_ShortestWayToFormString;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String source;

    @Parameterized.Parameter(1)
    public String target;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"abc", "abcbc", 2},
                {"abc", "acdbc", -1},
                {"xyz", "xzyxz", 3},
                {"abc", "abcd", -1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.shortestWay(source, target);
        Assert.assertEquals(expected, result);
    }

}