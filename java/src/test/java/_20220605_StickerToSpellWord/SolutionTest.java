package _20220605_StickerToSpellWord;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public String[] stickers;

    @Parameterized.Parameter(1)
    public String target;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new String[]{"with", "example", "science"}, "thehat", 3},
                {new String[]{"notice","possible"}, "basicbasic", -1},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minStickers(stickers, target);
        Assert.assertEquals(expected, result);
    }

}