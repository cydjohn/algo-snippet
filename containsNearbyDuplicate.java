//方法一：hashset + k-window remove
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashSet<Integer> set = new HashSet();
    	for (int i = 0; i < nums.length; i++) {
    		if (i > k) set.remove(nums[i-k-1]);
    		if (!set.add(nums[i])) return true;
    	}
    	return false;
    }
}

//Method 2: HashMap to record latest index