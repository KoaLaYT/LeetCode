package _20210910_TextJustification;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author koalayt 2021-09-10
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public String[] words;

    @Parameter(1)
    public int maxWidth;

    @Parameter(2)
    public List<String> expect;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {
                        new String[]{"This", "is", "an", "example", "of", "text", "justification."},
                        16,
                        Arrays.asList(
                                "This    is    an",
                                "example  of text",
                                "justification.  "
                        )
                },
                {
                        new String[]{"What", "must", "be", "acknowledgment", "shall", "be"},
                        16,
                        Arrays.asList(
                                "What   must   be",
                                "acknowledgment  ",
                                "shall be        "
                        )
                },
                {
                        new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"},
                        20,
                        Arrays.asList(
                                "Science  is  what we",
                                "understand      well",
                                "enough to explain to",
                                "a  computer.  Art is",
                                "everything  else  we",
                                "do                  "
                        )
                },
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<String> result = solution.fullJustify(words, maxWidth);
        Assert.assertArrayEquals(expect.toArray(), result.toArray());
    }

}