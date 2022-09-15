package _20220915_SumOfTwoIntegers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        for (int a = -1000; a <= 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                int result = solution.getSum(a, b);
                Assert.assertEquals(a + b, result);
            }
        }
    }

}