package _20220705_MedianFinder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MedianFinderTest {

    private static final double DELTA = 0.00001;

    private MedianFinder medianFinder;

    @Before
    public void setup() {
        medianFinder = new MedianFinder();
    }

    @Test
    public void test() {
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        Assert.assertEquals(1.5, medianFinder.findMedian(), DELTA);

        medianFinder.addNum(3);
        Assert.assertEquals(2, medianFinder.findMedian(), DELTA);
    }

}