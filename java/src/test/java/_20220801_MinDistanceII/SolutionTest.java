package _20220801_MinDistanceII;

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
    public String t;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"abcdefg", "abdde", 3},
                {"abc", "abc", 0},
                {"abc", "a", 2},
                {
                        "xiivhpthxqqmavzklkzfexoftdcdmtzadmupeileyalhdikflotwjdjobvaubmzpwcgbjmeiqrxqqgssvsoprhzguqgxgtlkhwnacmmlwdzoooeegzdxvsbzsoikvippbyvwlukrglcplhfcntvowfhuyjgduitmmoiisslblkvrvo",
                        "ndsxdmkdpayojjxmhdkglefhyehcmomludkgdjczbwzskjrtetnhosmkqipefayxplihzflywiqhriimbyryydmysavaimwtleeyzcddvqakulnhodoqvwddnfbaxazbzqsyitnuua",
                        146
                }
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.edit_distance(s, t);
        Assert.assertEquals(expected, result);
    }

}