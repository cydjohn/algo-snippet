public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
        	nums[i] += nums[i-1];
        }
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);//当当前元素和k相等时，返回i+1
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (map.containsKey(nums[i] - k)) {
        		max = Math.max(max, i - map.get(nums[i] - k));
        	}
        	if (!map.containsKey(nums[i])) {
        		map.put(nums[i], i);// keep only 1st duplicate as we want first index as left as possible
        	}
        }
        return max;
    }
}