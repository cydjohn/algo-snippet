public class Solution {
    List<List<Integer>> res = new ArrayList();
	List<Integer> list = new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);
        backtrack(0, 0, nums);
        return res;
    }
    private void backtrack(int cur, int st, int[] nums) {
    	if (cur <= nums.length) res.add(new ArrayList(list));
    	else return;
    	for (int i = st; i < nums.length; i++) {
    		list.add(nums[i]);
    		backtrack(cur+1, i+1, nums);
    		list.remove(list.size()-1);
    		while (i+1<nums.length && nums[i] == nums[i+1]) i++;
    	}
    }
}

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> res = new ArrayList();
        int len = nums.length;
        Arrays.sort(nums);
        for (int k = 0; k <= len; k++) {
        	res.addAll(search(nums, k, 0, 0));
        }
        return res;
    }
    private List<List<Integer>> search(int[] nums, int k, int start, int cur) {
    	List<List<Integer>> res = new ArrayList();
    	if (cur == k) {
    		List<Integer> temp = new ArrayList();
    		res.add(temp);
    		return res;
    	}
    	for (int i = start; i < nums.length; i++) {
    		List<List<Integer>> next = search(nums, k, i+1, cur+1);
    		if (next != null) {
    			for (List<Integer> t : next) t.add(0, nums[i]);
    			res.addAll(next);
    		}
            while (i < nums.length-1 && nums[i] == nums[i+1]) i++;
    	}
    	return res;
    }
}

