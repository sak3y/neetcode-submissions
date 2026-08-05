class Twitter {
    Map<Integer, Set<Integer>> followerMap; // maps userIds => their following list
    Map<Integer, List<int[]>> tweetMap; // Maps userIds => list of [tweet, timestamp]
    int time;

    public Twitter() {
        time = 0;
        followerMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[] {time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        // userId => maps followers => maps (posts + own posts)

        List<int[]> feed =
            new ArrayList<>(tweetMap.getOrDefault(userId, new ArrayList<>())); // user's own posts

        // Go thru each follower of user, update the feed with all followers tweets
        for (int followeeId : followerMap.getOrDefault(userId, new HashSet<>())) {
            feed.addAll(tweetMap.getOrDefault(followeeId, new ArrayList<>()));
        }

        // So the feed chronologically
        feed.sort((a, b) -> Integer.compare(b[0], a[0]));

        // Parse irst 10 tweets from feed and add them to result
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.min(10, feed.size()); i++) {
            res.add(feed.get(i)[1]);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followerMap.putIfAbsent(followerId, new HashSet<>());
            followerMap.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        followerMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}

/*
    Users can:
    - Post
    - Follow
    - Unfollow
    - View 10 most recenet tweets

    postTweet:
        - publishes tweet with a tweetid => assume unique
        - and userID

    getNewsFeeds:
        - gets 10 most recent tweet ids in new feed
        - can only contain tweets of people the user follows or their own tweets
        - ordered from most recent to least recent
        - essentiatly each user should have their own personalised feeds

    follow
        - takes follower and followee
        - one follows the other
        - global recourds updated

    unfollow
        - takes follower and followee
        - assuming one follows the other, removes the follow
        - updates global record


    Users can post which updates the global record
    when a user requests their news feed,, it checks the global record of who thier following +
   their own posts return up to 10 of them going to from most ot least recent
    - user follows, updates global record and vice versa

    What needs to be know
    - Who follows who => hashmap, with ids for follows, and then a list of who they're following
    - Who has posted what and when => hashmap with ids, and also a list of values with timestamps
   and post ids


*/