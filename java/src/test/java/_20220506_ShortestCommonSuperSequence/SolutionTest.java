package _20220506_ShortestCommonSuperSequence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String str1;

    @Parameterized.Parameter(1)
    public String str2;

    @Parameterized.Parameter(2)
    public int len;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"abac", "cab", 5},
                {"aaaaaaaa", "aaaaaaaa", 8},
                {"cadb", "acbac", 7},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        String result = solution.shortestCommonSupersequence(str1, str2);
        Assert.assertEquals(len, result.length());
        isSubstring(result, str1);
        isSubstring(result, str2);
    }

    private void isSubstring(String result, String target) {
        Assert.assertTrue(result.length() >= target.length());
        int i = 0, j = 0;
        while (i < result.length() && j < target.length()) {
            if (result.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        Assert.assertEquals(target.length(), j);
    }

}