package _20211002_RestoreIPAddresses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author koalayt 2021-10-02
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public String s;

    @Parameter(1)
    public List<String> expect;

    @Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"25525511135", Arrays.asList("255.255.111.35", "255.255.11.135")},
                {"0000", Arrays.asList("0.0.0.0")},
                {"1111", Arrays.asList("1.1.1.1")},
                {"010010", Arrays.asList("0.100.1.0", "0.10.0.10")},
                {"101023", Arrays.asList("101.0.2.3", "10.10.2.3", "10.1.0.23", "1.0.102.3", "1.0.10.23")},
                {"", Collections.emptyList()},
                {"1", Collections.emptyList()},
                {"999999999999999999999999999", Collections.emptyList()},
                {"00000", Collections.emptyList()}
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        List<String> result = solution.restoreIpAddresses(s);
        Assert.assertArrayEquals(expect.toArray(), result.toArray());
    }

}