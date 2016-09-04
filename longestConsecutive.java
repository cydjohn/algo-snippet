//remove to avoid dupicate counts
public class Solution {
    public int longestConsecutive(int[] nums) {
    	Set<Integer> set = new HashSet();
    	for (int i : nums) set.add(i);
    	int max = 0;

    	for (int i : nums) {
    		int count = 0;
    		if (set.isEmpty()) break;

    		int val = i;
    		while (set.remove(val--))
    			count++;

    		val = i + 1;
    		while (set.remove(val++))
    			count++;

    		max = Math.max(count, max);
    	}
    	return max;
    }
}

//DFS: StackOverFlow Error
public class Solution {
	private int len;
	HashMap<Integer, Boolean> marked = new HashMap();
    public int longestConsecutive(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> set = new HashMap();
        
        int max = 0;
        for (int i : nums) {
        	set.put(i, 1);
        	marked.put(i, false);
        }
        for (int i : nums) {
        	if (!marked.get(i)) {
        		len = 0;
        		dfs(set, i);
        		if (len > max) max = len;
        	}
        }
        return max;
    }

    private void dfs(HashMap<Integer, Integer> set, int i) {
    	if (!set.containsKey(i) || marked.get(i)) return;
    	marked.put(i, true);
    	len++;
    	dfs(set, i-1);
    	dfs(set, i+1);
    }
}

//BFS
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> set = new HashMap();
        HashMap<Integer, Boolean> marked = new HashMap();       
        int max = 0;
        for (int i : nums) {
        	set.put(i, 1);
        	marked.put(i, false);
        }

        for (int i : nums) {
        	if (!marked.get(i)) {
        		Queue<Integer> queue = new LinkedList();
                queue.offer(i);
                int len = 0;
                while (!queue.isEmpty()) {
        	        int x = queue.poll();
        	        marked.put(x, true);
        	        len++;
        	        if (set.containsKey(x-1) && !marked.get(x-1)) queue.offer(x-1);
        	        if (set.containsKey(x+1) && !marked.get(x+1)) queue.offer(x+1);
                }
                if (len > max) max = len;
        	}
        }
        return max;
    }
}

