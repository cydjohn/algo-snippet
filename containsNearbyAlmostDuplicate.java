public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0 || k < 1) return false;
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        int bucket = 0;
        int j = t;
        if (t == 0) j == 1;
        for (int i = 0; i < nums.length; i++) {
        	bucket = nums[i] / j;
        	if (map.containsKey(bucket) && Math.abs(nums[map.get(bucket)] - nums[i]))
        }
    }
}