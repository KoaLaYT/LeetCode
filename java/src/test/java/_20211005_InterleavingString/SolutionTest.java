package _20211005_InterleavingString;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-10-05
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public String s1;

    @Parameter(1)
    public String s2;

    @Parameter(2)
    public String s3;

    @Parameter(3)
    public boolean expect;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"aabcc", "dbbca", "aadbbcbcac", true},
                {"aabcc", "dbbca", "aadbbbaccc", false},
                {"", "", "", true},
                {"a", "b", "a", false},
                {"", "abc", "abc", true},
                {
                        "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                        "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                        "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab",
                        false
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.isInterleave(s1, s2, s3);
        Assert.assertEquals(expect, result);
    }

}