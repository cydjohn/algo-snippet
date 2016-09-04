//DP O(N^2)
public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
        	for (int j = 1; j <= i/2; j++) {
        		dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i-j, dp[i-j]));
        	}
        }
        return dp[n];
    }
}

//O(N)
//https://discuss.leetcode.com/topic/45341/an-simple-explanation-of-the-math-part-and-a-o-n-solution
/*The first thing we should consider is : What is the max product if we break a number N into two factors?

I use a function to express this product: f=x(N-x)

When x=N/2, we get the maximum of this function.

However, factors should be integers. Thus the maximum is (N/2)*(N/2) when N is even or (N-1)/2 *(N+1)/2 when N is odd.

When the maximum of f is larger than N, we should do the break.

(N/2)*(N/2)>=N, then N>=4

(N-1)/2 *(N+1)/2>=N, then N>=5

These two expressions mean that factors should be less than 4, otherwise we can do the break and get a better product. The factors in last result should be 1, 2 or 3. Obviously, 1 should be abandoned. Thus, the factors of the perfect product should be 2 or 3.

The reason why we should use 3 as many as possible is

For 6, 3 * 3>2 * 2 * 2. Thus, the optimal product should contain no more than three 2.

Below is my accepted, O(N) solution.*/
public class Solution {
    public int integerBreak(int n) {
    	if (n == 2) return 1;
    	if (n == 3) return 2;
    	int res = 1;
    	while (n > 4) {
    		res *= 3;
    		n -= 3;
    	}
    	res *= n;
    	return res;
    }
}
