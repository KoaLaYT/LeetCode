package _20220313_RangeSumQuery2DImmutable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class NumMatrixTest {

    private NumMatrix numMatrix;

    @Parameterized.Parameter
    public int[][] matrix;

    @Parameterized.Parameter(1)
    public int[][] inputs;

    @Parameterized.Parameter(2)
    public int[] expects;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}},
                        new int[][]{{2, 1, 4, 3}, {1, 1, 2, 2}, {1, 2, 2, 4}},
                        new int[]{8, 11, 12}},
        };
    }

    @Before
    public void setup() {
        numMatrix = new NumMatrix(matrix);
    }

    @Test
    public void test() {
        for (int i = 0; i < inputs.length; i++) {
            int result = numMatrix.sumRegion(inputs[i][0], inputs[i][1], inputs[i][2], inputs[i][3]);
            Assert.assertEquals(expects[i], result);
        }
    }

}