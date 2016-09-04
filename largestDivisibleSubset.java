//dp count + parent tracker
//the array must be a geometric progression
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	List<Integer> res = new ArrayList();
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        int[] dp = new int[nums.length]; //the longest subset that includes the ith num
        int[] parent = new int[nums.length];
        Arrays.fill(dp, 1); //even though dp[i] could not be divided by other nums, dp[i] itself is divisible subset at the very beginning.
        for (int i = 1; i < nums.length; i++) {
        	for (int j = i-1; j >= 0; j--) {
        		if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
        			dp[i] = dp[j] + 1;
        			parent[i] = j;
        		}
        	}
        }
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (dp[i] > dp[maxIdx]) maxIdx = i;
        }
        int p = maxIdx;
        for (int i = 0; i < dp[maxIdx]; i++) {
        	res.add(nums[p]);
        	p = parent[p];
        }
        return res;
    }
}