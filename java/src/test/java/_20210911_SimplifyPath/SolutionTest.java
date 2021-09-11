package _20210911_SimplifyPath;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-09-11
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public String path;

    @Parameter(1)
    public String expect;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"/home/", "/home"},
                {"/../", "/"},
                {"/home//foo/", "/home/foo"},
                {"/a/./b/../../c/", "/c"},
                {"/a//b////c/d//././/..", "/a/b/c"}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        String result = solution.simplifyPath(path);
        Assert.assertEquals(expect, result);
    }

}