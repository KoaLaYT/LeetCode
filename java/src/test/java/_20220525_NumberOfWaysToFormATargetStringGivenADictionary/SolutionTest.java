package _20220525_NumberOfWaysToFormATargetStringGivenADictionary;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String[] words;

    @Parameterized.Parameter(1)
    public String target;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new String[]{"acca", "bbbb", "caca"}, "aba", 6},
                {new String[]{"abba", "baab"}, "bab", 4},
                {new String[]{"cbabddddbc", "addbaacbbd", "cccbacdccd", "cdcaccacac", "dddbacabbd", "bdbdadbccb", "ddadbacddd", "bbccdddadd", "dcabaccbbd", "ddddcddadc", "bdcaaaabdd", "adacdcdcdd", "cbaaadbdbb", "bccbabcbab", "accbdccadd", "dcccaaddbc", "cccccacabd", "acacdbcbbc", "dbbdbaccca", "bdbddbddda", "daabadbacb", "baccdbaada", "ccbabaabcb", "dcaabccbbb", "bcadddaacc", "acddbbdccb", "adbddbadab", "dbbcdcbcdd", "ddbabbadbb", "bccbcbbbab", "dabbbdbbcb", "dacdabadbb", "addcbbabab", "bcbbccadda", "abbcacadac", "ccdadcaada", "bcacdbccdb"}, "bcbbcccc", 677452090},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.numWays(words, target);
        Assert.assertEquals(expected, result);
    }

}