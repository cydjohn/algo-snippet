//HashMap + max PQ O(nlogn) 
public class Solution {
	private class Pair{
		int num;
		int cnt;
		public Pair(int n, int c) {
			num = n;
			cnt = c;
		}
	}
    public List<Integer> topKFrequent(int[] nums, int k) {
    //create a hashmap to store nums(key) and their counts(value)
    	HashMap<Integer, Integer> map = new HashMap();
    //travel the list, if the num doesn't exit, put a new pair (num, 1); if the num do exit, add its value by 1
    	for (int i : nums) {
    		if (map.containsKey(i))
    			map.put(i, map.get(i)+1);
    		else
    			map.put(i, 1);
    	}
    	//create a max heap
    	PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Pair>() {
    		@Override
    		public int compare(Pair a, Pair b) {
    			return b.cnt - a.cnt;
    		}
    	});
    	//maintain a heap
    	for (Map.Entry<Integer, Integer> e : map.entrySet()) {
    		Pair p = new Pair(e.getKey(), e.getValue());
    		pq.offer(p);
    	}
    	//get the first k element from the max heap
    	List<Integer> res = new ArrayList();
    	while (k > 0) {
    		res.add(pq.poll().num);
    		k--;
    	}
    	return res;
    }
}

//imporovement: use min heap to reduce heapifying time
//O(nlogk)
public class Solution {
	private class Pair{
		int num;
		int cnt;
		public Pair(int n, int c) {
			num = n;
			cnt = c;
		}
	}
    public List<Integer> topKFrequent(int[] nums, int k) {
    //create a hashmap to store nums(key) and their counts(value)
    	HashMap<Integer, Integer> map = new HashMap();
    //travel the list, if the num doesn't exit, put a new pair (num, 1); if the num do exit, add its value by 1
    	for (int i : nums) {
    		if (map.containsKey(i))
    			map.put(i, map.get(i)+1);
    		else
    			map.put(i, 1);
    	}
    	//create a min heap
    	PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Pair>() {
    		@Override
    		public int compare(Pair a, Pair b) {
    			return a.cnt - b.cnt;
    		}
    	});
    	//maintain a heap with size of k
    	for (Map.Entry<Integer, Integer> e : map.entrySet()) {
    		Pair p = new Pair(e.getKey(), e.getValue());
    		pq.offer(p);
    		if (pq.size() > k) pq.poll(); //remove the e with smallest cnt
    	}
    	//get all num from min heap
    	List<Integer> res = new ArrayList();
    	while (pq.size() > 0) {
    		res.add(pq.poll().num);
    	}
    	return res;
    }
}


//HashMap + List O(n^2)
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
    //create a hashmap to store nums(key) and their counts(value)
    	HashMap<Integer, Integer> h = new HashMap();
    //travel the list, if the num doesn't exit, put a new pair (num, 1); if the num do exit, add its value by 1
    	int size = nums.length;
    	for (int i : nums) {
    		if (h.containsKey(i))
    			h.put(i, h.get(i)+1);
    		else
    			h.put(i, 1);
    	}
    //sort the map according to its value with a arraylist victor.
    	List<Integer>[] vs = new ArrayList[size+1];
    	for (int i : h.keySet()) {
    		int p = h.get(i);
    		if (vs[p] == null) vs[p] = new ArrayList();
    		vs[p].add(i);
    	}
    //travel keyset of nums, keep a list to represent the k most frequent keys.
    	List<Integer> ans = new ArrayList(k);   	
    		for (int j = size; j > 0; j--) {
    			if (vs[j] != null) {
    				for (int i = 0; i < vs[j].size() && k > 0; i++) {
    				    ans.add(vs[j].get(i));
    				    k--;
    			    }
    			}
    		}
    		return ans;
    }
}

