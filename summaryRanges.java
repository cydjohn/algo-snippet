public class Solution {
    List<String> res = new ArrayList();
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return res;
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1] + 1) {
                print(nums, start, i-1);
                start = i;
            }
        }
        print(nums, start, nums.length - 1);
        return res;
    }
    private void print(int[] nums, int s, int e) {
        if (s == e) res.add(Integer.toString(nums[s]));
        else res.add(Integer.toString(nums[s]) + "->" + Integer.toString(nums[e]));
    }
}