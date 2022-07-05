package _20220705_MedianFinderII;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MedianFinderIITest {

    private static final double DELTA = 0.00001;

    private MedianFinderII medianFinderII;

    private void assertMedian(double expected) {
        Assert.assertEquals(expected, medianFinderII.findMedian(), DELTA);
    }

    @Before
    public void setup() {
        medianFinderII = new MedianFinderII();
    }

    @Test
    public void testCase1() {
        medianFinderII.addNum(1);
        medianFinderII.addNum(2);
        assertMedian(1.5);

        medianFinderII.addNum(3);
        assertMedian(2);

        medianFinderII.addNum(100);
        assertMedian(2.5);

        medianFinderII.addNum(100);
        assertMedian(3);
    }

    @Test
    public void testCase2() {
        assertMedian(-1.0);

        medianFinderII.addNum(82);
        assertMedian(82);
        assertMedian(82);
        assertMedian(82);

        medianFinderII.addNum(13);
        medianFinderII.addNum(58);
        assertMedian(58);
    }

}