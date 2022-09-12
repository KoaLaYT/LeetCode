package _20220912_DesignTwitter;

import java.util.*;

public class Twitter {

    private static final int SIZE = 10;
    private static int TIMESTAMP = 0;

    // userId -> posted tweets
    private final Map<Integer, Node> tweets;
    // userId -> follwees
    private final Map<Integer, Set<Integer>> follows;

    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Node node = tweets.get(userId);
        Node head = new Node(new Tweet(tweetId));
        head.next = node;
        tweets.put(userId, head);
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followees = follows.getOrDefault(userId, Collections.emptySet());
        List<Node> tweets = new ArrayList<>(followees.size() + 1);

        for (int followeeId : followees) {
            tweets.add(this.tweets.get(followeeId));
        }
        tweets.add(this.tweets.get(userId));

        List<Integer> result = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            Tweet latest = null;
            int index = -1;
            for (int j = 0; j < tweets.size(); j++) {
                Node node = tweets.get(j);
                if (node == null) {
                    continue;
                }
                if (latest == null || node.tweet.timestamp > latest.timestamp) {
                    latest = node.tweet;
                    index = j;
                }
            }
            if (latest == null) break;
            result.add(latest.id);
            Node next = tweets.get(index).next;
            tweets.set(index, next);
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = follows.get(followerId);
        if (followees != null && followees.size() > 0) {
            followees.remove(followeeId);
        }
    }

    private static class Tweet {
        int id;
        int timestamp;

        Tweet(int id) {
            this.id = id;
            this.timestamp = TIMESTAMP++;
        }
    }

    private static class Node {
        Tweet tweet;
        Node next;

        Node(Tweet tweet) {
            this.tweet = tweet;
            this.next = null;
        }
    }

}
