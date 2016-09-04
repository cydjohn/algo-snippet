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