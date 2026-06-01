class Tweet {
    int time;
    int userId;
    int tweetId;
    int index; //index of tweet in user's tweet list

    public Tweet(int time, int userId, int tweetId, int index) {
        this.time = time;
        this.userId = userId;
        this.tweetId = tweetId;
        this.index = index;
    }

    public int getTime() {
        return time;
    }
}

class Twitter {

    HashMap<Integer, HashSet<Integer>> followerToFollowees = new HashMap<>();
    HashMap<Integer, List<Tweet>> userToTweets = new HashMap<>();
    int time = 0; 

    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        time++;
        List<Tweet> tweets = userToTweets.computeIfAbsent(userId, k -> new ArrayList<>());
        tweets.add(new Tweet(time, userId, tweetId, tweets.size()));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(Comparator.comparingInt(Tweet::getTime).reversed());

        follow(userId, userId); 

        for (int followee : followerToFollowees.getOrDefault(userId, new HashSet<>())) {
            //get one tweet out of every followee and add to the minHeap 
            List<Tweet> tweets = userToTweets.get(followee);
            if (tweets!=null && !tweets.isEmpty()) {
                maxHeap.add(tweets.getLast());
            }
        }
        //now we have at least one tweet from every followee. 

        //now add 10 of the latest tweets from the maxHeap 
        while (!maxHeap.isEmpty() && newsFeed.size()<10) {
            Tweet mostRecentTweet = maxHeap.poll();
            newsFeed.add(mostRecentTweet.tweetId);
            List<Tweet> userTweets = userToTweets.get(mostRecentTweet.userId);
            int nextIndexToCheck = mostRecentTweet.index -1;
            if (nextIndexToCheck>-1) {
                maxHeap.add(userTweets.get(nextIndexToCheck));
            }
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> followees = followerToFollowees.computeIfAbsent(followerId, k->new HashSet<>());
        followees.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followees = followerToFollowees.computeIfAbsent(followerId, k->new HashSet<>());
        followees.remove(followeeId);
    }
}
