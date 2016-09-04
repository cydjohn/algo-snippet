//two pointers O(n^2) Time Limit Exceeded
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
        	//跳过重复数字减少循环并防止答案重复出现
        	if (i > 0 && nums[i] == nums[i-1]) continue;
        	for (int j = i+1, k = nums.length-1; j < k;) {
        		if (nums[i]+nums[j]+nums[k] == 0) {
        			list.add(Arrays.asList(nums[i], nums[j], nums[k]));
        			j++; k--;
        			while (j<k && nums[j] == nums[j-1]) j++;
        			while (j<k && nums[k] == nums[k+1]) k--;
        		}
        		else if (nums[i]+nums[j]+nums[k] > 0) k--;
        		else j++;
        	}
        }
        return list;
    }
}