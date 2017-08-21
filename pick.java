//method 1: without extra memory
class Solution {
    int nums[];
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int pick(int target) {
        int total = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                // randomly select an int from 0 to the nums of target. If x equals 0, set the res as the current index. The probability is always 1/nums for the latest appeared number. For example, 1 for 1st num, 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums).
                int x = random.nextInt(++total);
                res = x == 0 ? i : res;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

//method 2: with extra memory of hashmap
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
