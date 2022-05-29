package _20220529_PalindromePartitioningIII;

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
                {"abc", 2, 1},
                {"aabbc", 3, 0},
                {"leetcode", 8, 0},
                {"abab", 3, 1},
                {"ihhyviwv", 7, 0},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.palindromePartition(s, k);
        Assert.assertEquals(expected, result);
    }

}