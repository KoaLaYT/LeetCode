package _20220607_LCArray;

import org.junit.Assert;
import org.junit.Test;

public class LCArrayTest {

    @Test
    public void test() {
        LCArray l = new LCArray();
        Assert.assertEquals(0, l.size());
        l.push_back(95);
        l.pop_back();
        Assert.assertEquals(0, l.size());
        l.push_back(37);
        Assert.assertEquals(1, l.size());
        Assert.assertEquals(37, l.index(0));
        l.push_back(38);
        l.push_back(39);
        Assert.assertEquals(3, l.size());
        Assert.assertEquals(39, l.index(2));
    }

}