public class Solution {
    List<String> res = new ArrayList();
    public List<String> summaryRanges(int[] nums) {
    	if (nums.length == 0) return res;
        int start = 0, end = 0;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] == nums[i-1] + 1) end++;
        	else {
        		print(nums, start, end);
        		start = i;
        		end++;
        	}
        }
        print(nums, start, end);
        return res;
    }
    private void print(int[] nums, int start, int end) {
    	if (start == end) res.add(Integer.toString(nums[start]));
        else res.add(Integer.toString(nums[start])+"->"+Integer.toString(nums[end]));
    }
}