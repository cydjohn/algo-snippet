public class Solution {
	boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
    	vis = new boolean[nums.length];
    	Arrays.sort(nums);
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
    		    while (i < nums.length-1 && nums[i] == nums[i+1]) i++;
    		}
    	}
    	return res;
    }
}


public class Solution {
	List<List<Integer>> res = new ArrayList();
	Integer[] a;
	boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        a = new Integer[nums.length];
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(0, nums);
        return res;
    }
    private void backtrack(int cur, int[] nums) {
    	if (cur == nums.length) {
    		res.add(Arrays.asList(a.clone()));
    		return;
    	}
    	for (int i = 0; i < nums.length; i++) {
    		if (!vis[i]) {
    			a[cur] = nums[i];
    			vis[i] = true;
    			backtrack(cur+1, nums);
    			vis[i] = false;
    			while (i < nums.length-1 && nums[i] == nums[i+1]) i++;
    		}
    	}
    }
}