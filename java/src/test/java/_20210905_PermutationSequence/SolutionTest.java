package _20210905_PermutationSequence;

import lombok.Value;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

/**
 * @author koalayt 2021-09-05
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameter
    public TestCase testCase;

    @Parameters(name = "testcase:{index}")
    public static TestCase[] data() {
        return new TestCase[] {
                new TestCase(3, 3, "213"),
                new TestCase(4, 9, "2314"),
                new TestCase(3, 1, "123"),
                new TestCase(5, 21, "15324"),
                new TestCase(5, 24, "15432"),
                new TestCase(5, 18, "14532"),
                new TestCase(5, 1, "12345"),
                new TestCase(5, 2, "12354"),
                new TestCase(5, 89, "43512")
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        String result = solution.getPermutation(testCase.n, testCase.k);
        Assert.assertEquals(testCase.expect, result);
    }

    @Value
    public static class TestCase {
        int n;
        int k;
        String expect;
    }

}