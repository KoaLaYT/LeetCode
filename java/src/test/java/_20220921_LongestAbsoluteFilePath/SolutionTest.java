package _20220921_LongestAbsoluteFilePath;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String input;

    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext", 20},
                {"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext", 32},
                {"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tfile 2.ext", 22},
                {"a", 0},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.lengthLongestPath(input);
        Assert.assertEquals(expected, result);
    }

}