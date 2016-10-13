public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList();
        long pre = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
        	long after = i == nums.length ? upper+1 : nums[i];//upper+1 might go overflow
        	if (after - pre == 2) res.add(Long.toString(pre + 1));
            else if (after - pre > 2) res.add(Long.toString(pre+1) + "->" + Long.toString(after - 1));
        	pre = after;
        }
        return res;
    }
}