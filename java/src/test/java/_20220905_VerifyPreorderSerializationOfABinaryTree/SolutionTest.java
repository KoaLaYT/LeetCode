package _20220905_VerifyPreorderSerializationOfABinaryTree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String preorder;

    @Parameterized.Parameter(1)
    public boolean expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"9,3,4,#,#,1,#,#,2,#,6,#,#", true},
                {"9,3,4,#,#,1,#,#,2,#,#,#,#", false},
                {"1,#", false},
                {"9,#,#,1", false},
                {"#", true},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        boolean result = solution.isValidSerialization(preorder);
        Assert.assertEquals(expected, result);
    }

}