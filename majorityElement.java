public class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < len; i++) {
        	if (!map.containsKey(nums[i])) map.put(nums[i], 1);
        	else map.put(nums[i], map.get(nums[i]) + 1);
        	if (map.get(nums[i]) > len/2) return nums[i];
        }
        return 0;
    }
}