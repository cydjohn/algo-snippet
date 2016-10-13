//DP + greedy O(nk)
// If there's no constraint, we choose min cost for each house
//Since no same colors for adjacent houses, just select 2nd min cost color for i - 1
//Current row only relies on last row to: (1) Get current min1, min2 (2) Avoid same color
//So O(1) space is enough

public class Solution {
    public int minCostII(int[][] costs) {
         if (costs.length == 0 || costs[0].length == 0) return 0; 
         int n = costs.length, k = costs[0].length;
         int min1 = 0, min2 = 0, minIdx = -1;

         for (int i = 0; i < n; i++) {
            int m1 = Integer.MAX_VALUE;
            int m2 = m1;
            int idx = -1;
            for (int j = 0; j < k; j++) {
               int cost = costs[i][j] + (j == minIdx ? min2 : min1);
               if (cost < m1) {
                  m2 = m1;
                  m1 = cost;
                  idx = j;
               }else if (cost < m2) {
                  m2 = cost;
               }
            }
            min1 = m1; 
            min2 = m2;
            minIdx = idx;
         }
         return min1;       
    }
}