/*这道题给了我们一个二维数组，让我们求和不超过的K的最大子矩形，那么我们首先可以考虑使用brute force来解，就是遍历所有的子矩形，然后计算其和跟K比较，找出不超过K的最大值即可。就算是暴力搜索，我们也可以使用优化的算法，比如建立累加和，参见之前那道题Range Sum Query 2D - Immutable，我们可以快速求出任何一个区间和，那么下面的方法就是这样的，当遍历到(i, j)时，我们计算sum(i, j)，表示矩形(0, 0)到(i, j)的和，然后我们遍历这个矩形中所有的子矩形，计算其和跟K相比，这样既可遍历到原矩形的所有子矩形*/
//2d range sum O(m^2*n^2)
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m][n];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		sum[i][j] = matrix[i][j];
        		if (i > 0) sum[i][j] += sum[i-1][j];
        		if (j > 0) sum[i][j] += sum[i][j-1];
        		if (i > 0 && j > 0) sum[i][j] -= sum[i-1][j-1];
        		for (int p = 0; p <= i; p++) {
        			for (int q = 0; q <= j; q++) {
        				int d = sum[i][j];
        				if (p > 0) d -= sum[p-1][j];
        				if (q > 0) d -= sum[i][q-1];
        				if (p > 0 && q > 0) d += sum[p-1][q-1];
        				if (d <= k) res = Math.max(d, res);
        			}
        		}
        	}
        }
        return res;
    }
}