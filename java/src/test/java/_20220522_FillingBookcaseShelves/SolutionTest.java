package _20220522_FillingBookcaseShelves;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

    private Solution solution;

    @Parameterized.Parameter
    public int[][] books;

    @Parameterized.Parameter(1)
    public int shelfWidth;

    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4, 6},
                {new int[][]{{1, 3}, {2, 4}, {3, 2}}, 6, 4},
                {new int[][]{{2, 4}, {2, 4}, {1, 1}}, 4, 5},
        };
    }

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int result = solution.minHeightShelves(books, shelfWidth);
        Assert.assertEquals(expected, result);
    }

}