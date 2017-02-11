//two pointers + recirssove O(n^2)
public class Solution {
	int len = 0;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }
    private List<List<Integer>> kSum(int[] nums, int target, int k, int idx) {
    	List<List<Integer>> res = new ArrayList();
    	if (idx >= len) return res;
    	if (k == 2) {
    		int i = idx, j = len - 1;
    		while (i < j) {
    			if (nums[i] + nums[j] == target) {
    				List<Integer> temp = new ArrayList();//不要直接使用Arrays.asList()，因为这个结构是不能改变的，所以在下面不能add
    				temp.add(nums[i]);
    				temp.add(nums[j]);
    				res.add(temp);
    				i++; j--;
    				while (i<j && nums[i] == nums[i-1]) i++;
    				while (i<j && nums[j] == nums[j+1]) j--;
    			}
    			else if (nums[i] + nums[j] < target) i++;
    			else j--;
    		}
    	}
    	else {
    		for (int i = idx; i < len-k+1; i++) {
    			List<List<Integer>> temp = kSum(nums, target-nums[i], k-1, i+1);
    			if (temp != null) {
    				for (List<Integer> t : temp) t.add(0, nums[i]);
    				res.addAll(temp);
    			}
    			while (i < len-k+1 && nums[i] == nums[i+1]) i++;
    		}
    	}
    	return res;
    }
}

//hashtable O(n^2)
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
    }
}