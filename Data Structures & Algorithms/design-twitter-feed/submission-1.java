class Twitter {

      Map<Integer, List<TweetWithTimeStamp>> userFeed;
  Map<Integer, Set<Integer>> userFollows;
  Map<Integer, Queue<TweetWithTimeStamp>> userHomePageFeed;
  private static long globalTime = 0;

    public Twitter() {
            userFeed = new HashMap<>();
    userFollows = new HashMap<>();
    userHomePageFeed = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
         // Add user to self as follow
    if (!userFollows.containsKey(userId)) {
      Set<Integer> follows = new HashSet<>();
      follows.add(userId);
      userFollows.put(userId, follows);
    }
    userFeed
        .computeIfAbsent(userId, k -> new LinkedList<>())
        .add(0, new TweetWithTimeStamp(userId, tweetId, ++globalTime));
    // Cant use epoch as processor is adding feeds within nanoseconds, while epoch resolution is
    // upto millisecond
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> follows = userFollows.get(userId);
    Queue<TweetWithTimeStamp> tweetMinHeap =
        new PriorityQueue<>(Comparator.comparingLong(TweetWithTimeStamp::getEpochTime));
    for (int follow : follows) {
      long lastFeedTimeStamp = 0;
      if (userFeed.containsKey(follow)) {
        for (TweetWithTimeStamp tweet : userFeed.get(follow)) {
          // Keep adding tweet to feed if size < 10
          if (tweetMinHeap.size() < 10) {
            tweetMinHeap.add(tweet);
          } else { // if size is >= 10
            lastFeedTimeStamp = tweetMinHeap.peek().getEpochTime();
            if (lastFeedTimeStamp >= tweet.getEpochTime()) {
              // List is reverse sorted. So no need to check further.
              break;
            } else {
              tweetMinHeap.add(tweet);
            }
            if (tweetMinHeap.size() > 10) {
              tweetMinHeap.poll();
            }
          }
        }
      }
         }
    return tweetMinHeap.stream()
        .sorted(Comparator.comparingLong(TweetWithTimeStamp::getEpochTime).reversed())
        .map(TweetWithTimeStamp::getTweetId)
        .collect(Collectors.toList());   
    }
    
    public void follow(int followerId, int followeeId) {
            userFollows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);

    }
    
    public void unfollow(int followerId, int followeeId) {
    if (followerId != followeeId && userFollows.containsKey(followerId)) {
      userFollows.get(followerId).remove(followeeId);
    }
    }
      
class TweetWithTimeStamp {
    public int userId;
    public int tweetId;
    public long epochTime;

    public TweetWithTimeStamp(int userId, int tweetId, long epochTime) {
      this.userId = userId;
      this.tweetId = tweetId;
      this.epochTime = epochTime;
    }

    public long getEpochTime() {
        return epochTime;
    }

    public int getTweetId() {
        return tweetId;
    }

    @Override
    public String toString() {
      return "TweetWithTimeStamp{"
          + "userId="
          + userId
          + ", tweetId="
          + tweetId
          + ", epochTime="
          + epochTime
          + '}';
    }
  }
}
