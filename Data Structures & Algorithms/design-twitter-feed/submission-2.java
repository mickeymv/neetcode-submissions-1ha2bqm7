class Node {
    int time;
    int tweetId;

    public Node(int time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
    }

    public int getTime() {
        return time;
    }
}

class Twitter {

    HashMap<Integer, TreeMap<Integer, Integer>> userToTweets = new HashMap<>();
    HashMap <Integer, Set<Integer>> userFollows = new HashMap<>();
    int time = 0;

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        if (userToTweets.containsKey(userId)) {
            TreeMap<Integer, Integer> tweets = userToTweets.get(userId);
            tweets.put(time, tweetId);
        } else {
            TreeMap<Integer, Integer> tweets = new TreeMap<>(Collections.reverseOrder());
            tweets.put(time, tweetId);
            userToTweets.put(userId, tweets);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        TreeMap<Integer, Integer> feed = new TreeMap<>(Collections.reverseOrder());
        //^ the treeMap is automatically sorted according to most recent time
        follow(userId, userId);

        for (int followeeId: userFollows.get(userId)) {
            if (!userToTweets.containsKey(followeeId)) {
                continue;
            }
            TreeMap<Integer, Integer> followeeTweets = userToTweets.get(followeeId);
            Iterator<Integer> times = followeeTweets.keySet().iterator();
            //add every followee's most recent 10 tweets
            for (int i=1; i<= Math.min(10, followeeTweets.size());i++) {
                int time = times.next();
                feed.put(time, followeeTweets.get(time));
            }
        }

        ArrayList<Integer> topTenOfFeed = new ArrayList<>();

        Iterator<Integer> times = feed.keySet().iterator();
        for (int i=1; i<= Math.min(10, feed.size());i++) {
            int time = times.next();
            topTenOfFeed.add(feed.get(time));
        }

        return topTenOfFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (userFollows.containsKey(followerId)) {
            Set<Integer> followees =  userFollows.get(followerId);
            followees.add(followeeId);
        } else {
            Set<Integer> followees = new HashSet<>();
            followees.add(followeeId);
            userFollows.put(followerId, followees);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (userFollows.containsKey(followerId)) {
            Set<Integer> followees =  userFollows.get(followerId);
            followees.remove(followeeId);
        } 
    }
}
