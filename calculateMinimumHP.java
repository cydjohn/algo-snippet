/*思路：在走完最后一个房间的时候血量至少要剩下１，因此最后的状态可以当成是初始状态，由后往前依次决定在每一个位置至少要有多少血量, 这样一个位置的状态是由其下面一个和和左边一个的较小状态决定 ．因此一个基本的状态方程是: dp[i][j] = min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]. 

但是还有一个条件就是在每一个状态必须血量都要大于１，因此我们还需要一个方程在保证在每一个状态都大于１，即：dp[i][j] = max(dp[i][j], 1);　也就是说虽然当前的血量到最后能够剩下１，但是现在已经低于１了，我们需要为其提升血量维持每一个状态至少都为１．

这样我们需要一个二维数组在记录我们需要的之前的状态，也就是一个位置的下方和左方的状态．而其下方的状态可以存储在其当前位置，因此我们可以做状态压缩，只需要一维的数组．*/
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        dp[m-1][n] = 1; 
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int val = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = Math.max(val, 1);
            }
        }
        return dp[0][0];
    }
}