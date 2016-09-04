//DP
/*当 n==0 时 ， 自然为 0 ;
当 n==1 时 ，可构成 1 颗 ;
当 n==2 时 ，可构成 2 颗 ;
当 n>2 时，任意 [1,n] 中的值都可做为根节点； 
求解方式为： 
声明数组 dp[i] 记录i个数字时，可构成的二叉查找树数目; 
对于i个数字时，任一[0,i-1] 内一元素j均可作为根节点，且[0,j−1]为当前左子树，[j+1,i-1] 为当前右子树； 
因为， 
[0,j−1] 可构成的子树数目，即等于 lefts=dp[j] 
[j+1,i-1] 为 i-j-1 个连续元素，其构成的子树数目等于 rights=dp[i-j-1] 
故，当 n=i 时，可构成lefts*rights个不同结构。*/
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	for (int j = 0; j < i; j++) {
        		dp[i] += dp[j] * dp[i-j-1];
        	}
        }
        return dp[n];
    }
}