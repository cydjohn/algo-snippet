public class Twitter {
    public class Tweet {
        int uid;
        int tid;
        public Tweet(int uid, int tid) {
            this.uid = uid;
            this.tid = tid;
        }
    }
    Map<Integer, HashSet<Integer>> map;
    List<Tweet> list;
    /** Initialize your data structure here. */
    public Twitter() {
        map = new HashMap();
        list = new ArrayList();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        //发信息前要检查该ID是否存在，否则getTweet时会无法得到该ID的信息
        if (!map.containsKey(userId)) {
            map.put(userId, new HashSet<Integer>());
            map.get(userId).add(userId);
        }
        list.add(new Tweet(userId, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList();
        if (!map.containsKey(userId)) return res;
        int k = 10, i = list.size()-1;
        
        while (k > 0 && i >= 0) {
            if (!map.get(userId).contains(list.get(i).uid)) {
                i--;
                continue;
            }
            res.add(list.get(i--).tid);
            k--;
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            map.put(followerId, new HashSet<Integer>());
            map.get(followerId).add(followerId);
        }
        if (map.get(followerId).contains(followeeId)) return;
        map.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        //自己不能unfollow自己
        if (!map.containsKey(followerId) || !map.get(followerId).contains(followeeId) || followerId == followeeId) return;
        map.get(followerId).remove(followeeId);
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




