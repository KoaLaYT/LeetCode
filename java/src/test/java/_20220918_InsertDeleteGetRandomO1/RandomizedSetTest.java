package _20220918_InsertDeleteGetRandomO1;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Set;

public class RandomizedSetTest {

    private RandomizedSet randomizedSet;

    @Test
    public void testCase1() {
        randomizedSet = new RandomizedSet();
        Assert.assertTrue(randomizedSet.insert(1));
        Assert.assertFalse(randomizedSet.remove(2));
        Assert.assertTrue(randomizedSet.insert(2));
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(Set.of(1, 2).contains(randomizedSet.getRandom()));
        }
        Assert.assertTrue(randomizedSet.remove(1));
        Assert.assertFalse(randomizedSet.insert(2));
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(2, randomizedSet.getRandom());
        }
    }

    @Test
    public void testCase2() {
        randomizedSet = new RandomizedSet();
        Assert.assertTrue(randomizedSet.insert(0));
        Assert.assertTrue(randomizedSet.insert(1));
        Assert.assertTrue(randomizedSet.remove(0));
        Assert.assertTrue(randomizedSet.insert(2));
        Assert.assertTrue(randomizedSet.remove(1));
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(2, randomizedSet.getRandom());
        }
    }

    @Test
    public void testCase3() {
        randomizedSet = new RandomizedSet();
        Assert.assertFalse(randomizedSet.remove(0));
        Assert.assertFalse(randomizedSet.remove(0));
        Assert.assertTrue(randomizedSet.insert(0));
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(0, randomizedSet.getRandom());
        }
        Assert.assertTrue(randomizedSet.remove(0));
        Assert.assertTrue(randomizedSet.insert(0));
    }

}