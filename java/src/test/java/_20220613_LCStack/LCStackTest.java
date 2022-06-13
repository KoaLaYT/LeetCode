package _20220613_LCStack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class LCStackTest {

    private LCStack lcStack;

    @Before
    public void setup() {
        lcStack = new LCStack();
    }

    @Test
    public void test() {
        Assert.assertEquals(0, lcStack.size());
        lcStack.push(52);
        Assert.assertEquals(52, lcStack.top());
        lcStack.push(22);
        Assert.assertEquals(22, lcStack.top());
        Assert.assertEquals(2, lcStack.size());
        lcStack.pop();
        Assert.assertEquals(52, lcStack.top());
    }

}