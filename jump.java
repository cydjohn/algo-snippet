/*cnt:目前为止的jump数
curRch:从A[0]进行cnt次jump之后达到的最大范围
curMax:从0~i这i+1个A元素中能达到的最大范围
当curRch < i，说明ret次jump已经不足以覆盖当前第i个元素，因此需要增加一次jump，使之达到
记录的curMax。*/
public class Solution {
    public int jump(int[] nums) {
        int curRch = 0, curMax = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            //当curRch >= nums.length-1，cnt将不再可能增加
            //不能写成curRch < curMax，因为可能在当前可达到的range里比较靠后的位置可以一步跳到更远的地方，应该走完当前的range并等待选择这一步
            //也可以在这里用一个for loop找出当前range的最大可能跳
            if (curRch < i) { 
                cnt++;
                curRch = curMax;
            }
            curMax = Math.max(curMax, i + nums[i]);
        }
        return cnt;
    }
}

//dp O(n^2) Time Limit Exceeded
public class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1;  j <= Math.min(nums.length-1, i+nums[i]); j++) {
                dp[j] = Math.min(dp[j], dp[i]+1);
            }
        } 
        return dp[nums.length-1];       
    }
}