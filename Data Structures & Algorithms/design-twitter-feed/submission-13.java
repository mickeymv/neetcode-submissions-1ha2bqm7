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
        PriorityQueue<Node> feed = new PriorityQueue<>(Comparator.comparingInt(Node::getTime));
        //^ use a min heap, as when we pop we will pop the earlier tweets away 
        if (userToTweets.containsKey(userId)) {
            TreeMap<Integer, Integer> userTweets = userToTweets.get(userId);
            Iterator<Integer> times = userTweets.keySet().iterator();
            //add most recent 10 tweets
            for (int i=1; i<= Math.min(10, userTweets.size());i++) {
                int time = times.next();
                feed.add(new Node(time, userTweets.get(time)));
            }
        }
        
        if (userFollows.containsKey(userId)){

        for (int followeeId: userFollows.get(userId)) {
            if (!userToTweets.containsKey(followeeId)) {
                continue;
            }
            TreeMap<Integer, Integer> followeeTweets = userToTweets.get(followeeId);
            Iterator<Integer> times = followeeTweets.keySet().iterator();
            //add every followee's most recent 10 tweets
            for (int i=1; i<= Math.min(10, followeeTweets.size());i++) {
                int time = times.next();
                feed.add(new Node(time, followeeTweets.get(time)));
                                if (feed.size()>10) {
                    feed.poll();
                }
            }
        }}

        ArrayList<Integer> topTenOfFeed = new ArrayList<>();

        int sizeOfFinalFeed = Math.min(10, feed.size());

        for (int i=1; i<= sizeOfFinalFeed;i++) {
            topTenOfFeed.add(feed.poll().tweetId);
        }

        return topTenOfFeed.reversed();
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId==followeeId) {
            //no need to follow themselves 
            return;
        }
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
