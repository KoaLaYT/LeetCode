package _20220815_RepeatedDNASequences;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

  private Solution solution;

  @Parameter
  public String s;

  @Parameter(1)
  public List<String> expected;

  @Parameters
  public static Object[][] data() {
    return new Object[][]{
        {"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", Arrays.asList("AAAAACCCCC", "CCCCCAAAAA")},
        {"AAAAAAAAAAAAA", Arrays.asList("AAAAAAAAAA")},
    };
  }

  @Before
  public void setup() {
    solution = new Solution();
  }

  @Test
  public void test() {
    List<String> result = solution.findRepeatedDnaSequences(s);
    Assert.assertEquals(expected.size(), result.size());
    for (String expect : expected) {
      Assert.assertTrue(result.contains(expect));
      result.remove(expect);
    }
  }

}