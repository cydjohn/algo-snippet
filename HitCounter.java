public class HitCounter {
	HashMap<Integer, Integer> map;
	List<Integer> list;
    /** Initialize your data structure here. */
    public HitCounter() {
        map = new HashMap();
        list = new ArrayList();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (!map.containsKey(timestamp)) {
        	map.put(timestamp, 1);
        	list.add(timestamp);
        }else {
        	map.put(timestamp, map.get(timestamp)+1);
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	int p = list.size() - 1;
    	int cnt = 0;
        while (p >= 0 && list.get(p) > timestamp - 300) {
        	cnt += map.get(list.get(p));
        }
        return cnt;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */