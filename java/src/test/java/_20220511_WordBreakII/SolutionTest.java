package _20220511_WordBreakII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String s;

    @Parameterized.Parameter(1)
    public List<String> wordDict;

    @Parameterized.Parameter(2)
    public List<String> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"),
                        Arrays.asList("cats and dog", "cat sand dog")},
                {"pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"),
                        Arrays.asList("pine apple pen apple", "pineapple pen apple", "pine applepen apple")},
                {"catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"),
                        Collections.emptyList()},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<String> result = solution.wordBreak(s, wordDict);
        Assert.assertEquals(expected.size(), result.size());

        for (String res : result) {
            Assert.assertTrue(expected.contains(res));
        }
    }

}