package _20220920_MiniParser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String s;

    @Parameterized.Parameter(1)
    public NestedInteger expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"324", new NestedInteger(324)},
                {"[123,[456,[789]]]", buildCase2()},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        NestedInteger result = solution.deserialize(s);
        assertEquals(expected, result);
    }

    private static void assertEquals(NestedInteger expected, NestedInteger result) {
        if (expected.isInteger()) {
            Assert.assertTrue(result.isInteger());
            Assert.assertEquals(expected.getInteger(), result.getInteger());
            return;
        }

        List<NestedInteger> nestedExpected = expected.getList();
        List<NestedInteger> nestedResult = result.getList();
        Assert.assertEquals(nestedExpected.size(), nestedResult.size());

        for (int i = 0; i < nestedExpected.size(); i++) {
            assertEquals(nestedExpected.get(i), nestedResult.get(i));
        }
    }

    private static NestedInteger buildCase2() {
        NestedInteger n2 = new NestedInteger();
        n2.add(new NestedInteger(789));

        NestedInteger n1 = new NestedInteger();
        n1.add(new NestedInteger(456));
        n1.add(n2);

        NestedInteger n0 = new NestedInteger();
        n0.add(new NestedInteger(123));
        n0.add(n1);

        return n0;
    }

}