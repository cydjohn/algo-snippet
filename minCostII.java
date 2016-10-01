public class Solution {
    public int minCostII(int[][] costs) {
         int n = costs.length, k = costs[0].length;
         int min1 = 0, min2 = 0, minIdx = -1;

         for (int i = 0; i < n; i++) {
         	int m1 = Integer.MAX_VALUE;
         	int m2 = m1;
         	int idx = -1;
         	for (int j = 0; j < n; j++) {
         		int cost = costs[i][j] + (j == idx ? min2 : min1);
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