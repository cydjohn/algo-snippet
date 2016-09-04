//interative
public class Solution {
	List<List<Integer>> res = new ArrayList();
	Integer[] a;
	boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
    	int n = nums.length;
        a = new Integer[n];
        vis = new boolean[n];
        backtrack(0, nums);
        return res;
    }
    private void backtrack(int cur, int[] n) {
    	if (cur == n.length) {
    		res.add(Arrays.asList(a.clone()));
    		return;
    	}
    	for (int i = 0; i < n.length; i++) {
    		if (!vis[i]) {
    			a[cur] = n[i];
    			vis[i] = true;
    			backtrack(cur+1, n);
    			vis[i] = false;
    		}
    	}
    }
}

//recurssive
public class Solution {
	boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
    	vis = new boolean[nums.length];
        return search(nums, 0);
    }
    private List<List<Integer>> search(int[] nums, int cur) {
    	List<List<Integer>> res = new ArrayList();
    	if (cur == nums.length) {
    		List<Integer> temp = new ArrayList();
    		res.add(temp);
    		return res;
    	}
    	for (int i = 0; i < nums.length; i++) {
    		if (!vis[i]) {
    			vis[i] = true;
    		    List<List<Integer>> next = search(nums, cur+1);
    		    for (List<Integer> t : next) t.add(0, nums[i]);
    		    res.addAll(next);
    		    vis[i] = false;
    		}
    	}
    	return res;
    }
}

