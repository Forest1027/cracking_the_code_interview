package com.interview.basic.algorithms.real_world_problem;

import java.util.*;

/**
 * 355. Design Twitter
 * https://leetcode.com/problems/design-twitter/
 */
public class Twitter {
    private Map<Integer, User> users;
    private static int timeStamp = 0;

    public Twitter() {
        this.users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        User user = users.getOrDefault(userId, new User(userId));
        user.post(tweetId);
        users.put(userId, user);
    }

    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> res = new LinkedList<>();
        if (!users.containsKey(userId)) return res;
        Set<User> followed = users.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (User user : followed) {
            int n = 10;
            Iterator<Tweet> it = user.tweets.listIterator();
            while (n > 0 && it.hasNext()) {
                pq.add(it.next());
                n--;
            }
        }
        int n = 10;
        while (n > 0 && !pq.isEmpty()) {
            res.add(pq.remove().tweetId);
            n--;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        User follower = users.getOrDefault(followerId, new User(followerId));
        User followee = users.getOrDefault(followeeId, new User(followeeId));
        follower.follow(followee);
        users.put(followeeId, followee);
        users.put(followerId, follower);
    }

    public void unfollow(int followerId, int followeeId) {
        User follower = users.getOrDefault(followerId, new User(followerId));
        User followee = users.getOrDefault(followeeId, new User(followeeId));
        follower.unfollow(followee);
        users.put(followeeId, followee);
        users.put(followerId, follower);
    }

    public class User {
        private int userId;
        private Set<User> followed;
        private LinkedList<Tweet> tweets;

        public User(int userId) {
            this.userId = userId;
            this.followed = new HashSet<>();
            this.tweets = new LinkedList<>();
            // follow yourself first
            this.followed.add(this);
        }

        public void post(int tweetId) {
            this.tweets.addFirst(new Tweet(tweetId));
        }

        public void follow(User followee) {
            this.followed.add(followee);
        }

        public void unfollow(User followee) {
            this.followed.remove(followee);
        }
    }

    public class Tweet {
        private int tweetId;
        private int time;

        public Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.time = timeStamp++;
        }
    }

    public static void main(String[] args) {
        /**
         * ["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed"]
         * [[],[1,5],[1,3],[1,101],[1,13],[1,10],[1,2],[1,94],[1,505],[1,333],[1,22],[1,11],[1]]
         */
        Twitter obj = new Twitter();
        obj.postTweet(1, 5);
        obj.postTweet(1, 3);
        obj.postTweet(1, 101);
        obj.postTweet(1, 13);
        obj.postTweet(1, 10);
        obj.postTweet(1, 2);
        obj.postTweet(1, 94);
        obj.postTweet(1, 505);
        obj.postTweet(1, 333);
        obj.postTweet(1, 22);
        obj.postTweet(1, 11);
        System.out.println(obj.getNewsFeed(1));
        /*obj.follow(1, 2);
        obj.postTweet(2, 6);
        System.out.println(obj.getNewsFeed(1));
        obj.unfollow(1, 2);
        System.out.println(obj.getNewsFeed(1));*/
    }
}
