//hashmap O(n)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int j = 0, k = 0;
        for (; j < nums.length; j++) {
            if (map.containsKey(target - nums[j])) {
                k = map.get(target - nums[j]);
                break;
            }
            else map.put(nums[j], j);
        }
        return new int[]{j, k};
    }
}