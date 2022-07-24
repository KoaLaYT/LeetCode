package _20220724_CustomStack;

import org.junit.Assert;
import org.junit.Test;

public class CustomStackTest {

    private CustomStack customStack;

    @Test
    public void test() {
        customStack = new CustomStack(3);

        customStack.push(1);
        customStack.push(2);

        Assert.assertEquals(2, customStack.pop());

        customStack.push(2);
        customStack.push(3);
        customStack.push(4);

        customStack.increment(5, 100);
        customStack.increment(2, 100);

        Assert.assertEquals(103, customStack.pop());
        Assert.assertEquals(202, customStack.pop());
        Assert.assertEquals(201, customStack.pop());
        Assert.assertEquals(-1, customStack.pop());
    }

}