package _20220814_LRUCache;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {

    private LRUCache cache;

    @Test
    public void testCase1() {
        cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1));
        cache.put(3, 3);
        Assert.assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(3, cache.get(3));
        Assert.assertEquals(4, cache.get(4));
    }

    @Test
    public void testCase2() {
        cache = new LRUCache(3);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(2, cache.get(2));
        Assert.assertEquals(3, cache.get(3));
        Assert.assertEquals(4, cache.get(4));
    }

    @Test
    public void testCase3() {
        cache = new LRUCache(1);

        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(-1, cache.get(1));
        Assert.assertEquals(2, cache.get(2));
    }

}