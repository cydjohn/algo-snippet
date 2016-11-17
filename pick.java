public class Solution {
	Random random;
	Map<Integer, ArrayList<Integer>> map;
    public Solution(int[] nums) {
        random = new Random();
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<Integer>());
        	map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
    	if (!map.containsKey(target)) return -1;
        int k = random.nextInt(map.get(target).size());
        return map.get(target).get(k);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */