//Hashmap
//注意讨论删除以及添加成立的前提条件
public class Twitter {
	Map<Integer, List<Integer>> news;//<tCnt, [userId, tweetId]>
	Map<Integer, List<Integer>> users; //<followeeId, followerId>
	int tCnt;//counter for news
    /** Initialize your data structure here. */
    public Twitter() {
        news = new HashMap();
        users = new HashMap();
        tCnt = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Integer> list = new ArrayList();
        list.add(userId);
        list.add(tweetId);
        news.put(tCnt++, list);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followees = users.get(userId);
        List<Integer> res = new ArrayList();
        int k = tCnt - 1, i = 0;
        while (i < 10 && k >= 0) {
        	if ((followees != null && followees.contains(news.get(k).get(0))) || news.get(k).get(0) == userId) {
        		res.add(news.get(k).get(1));
        		i++;
        	}
        	k--;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new ArrayList<Integer>());
        }
        List<Integer> list = users.get(followerId);
        if (list.contains(followeeId)) return;
        list.add(followeeId);
        users.put(followerId, list);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!users.containsKey(followerId) || !users.get(followerId).contains(followeeId)) return;
        List<Integer> list = users.get(followerId);
        list.remove(new Integer(followeeId));
        users.put(followerId, list);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */