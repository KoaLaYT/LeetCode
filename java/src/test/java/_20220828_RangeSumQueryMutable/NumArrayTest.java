package _20220828_RangeSumQueryMutable;

import org.junit.Assert;
import org.junit.Test;

public class NumArrayTest {

    private NumArray numArray;

    @Test
    public void test() {
        numArray = new NumArray(new int[]{1, 3, 5});
        Assert.assertEquals(9, numArray.sumRange(0, 2));
        numArray.update(1, 2);
        Assert.assertEquals(8, numArray.sumRange(0, 2));
    }

}