package _20220912_DesignTwitter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

public class TwitterTest {

    private Twitter twitter;

    @Test
    public void test() {
        twitter = new Twitter();
        twitter.postTweet(1, 5);
        Assert.assertEquals(Arrays.asList(5), twitter.getNewsFeed(1));

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);

        Assert.assertEquals(Arrays.asList(6, 5), twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);
        Assert.assertEquals(Arrays.asList(5), twitter.getNewsFeed(1));
    }

}