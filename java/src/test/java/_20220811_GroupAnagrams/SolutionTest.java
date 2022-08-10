package _20220811_GroupAnagrams;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String[] strs;

    @Parameterized.Parameter(1)
    public List<List<String>> expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}, Arrays.asList(
                        Arrays.asList("bat"),
                        Arrays.asList("nat", "tan"),
                        Arrays.asList("ate", "eat", "tea")
                )},
                {new String[]{""}, Arrays.asList(Arrays.asList(""))},
                {new String[]{"a"}, Arrays.asList(Arrays.asList("a"))},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<List<String>> result = solution.groupAnagrams(strs);
        result.forEach(res -> res.sort(String::compareTo));
        result.sort(Comparator.comparingInt(List::size));
        Assert.assertEquals(expected, result);
    }

}