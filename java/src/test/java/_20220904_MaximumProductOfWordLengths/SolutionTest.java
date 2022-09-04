package _20220904_MaximumProductOfWordLengths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SolutionTest {

  private Solution solution;

  @Parameter
  public String[] words;

  @Parameter(1)
  public int expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}, 16},
        {new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}, 4},
        {new String[]{"a", "aa", "aaa", "aaaa"}, 0},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    int result = solution.maxProduct(words);
    Assert.assertEquals(expected, result);
  }

}