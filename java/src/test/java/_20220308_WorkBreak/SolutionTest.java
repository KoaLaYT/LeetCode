package _20220308_WorkBreak;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String s;

    @Parameterized.Parameter(1)
    public List<String> wordDict;

    @Parameterized.Parameter(2)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"leetcode", Arrays.asList("leet", "code"), true},
                {"applepenapple", Arrays.asList("apple", "pen"), true},
                {"catsandog", Arrays.asList("cat", "sand", "and", "dog", "cats"), false},
                {"abcd", Arrays.asList("a", "abc", "b", "cd"), true},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.wordBreak(s, wordDict);
        Assert.assertEquals(expected, result);
    }

}