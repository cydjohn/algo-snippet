//DP two travesal o(mn)
//可扩展为求两边四方之和和之积
public class Solution {
	public class Spot {
		int up;
		int down;
		int left;
		int right;

		public int sum() {
			return up + left + down + right;
		}
	}
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        Spot[][] s = new Spot[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j ++) {
        		s[i][j] = new Spot();
        		if (grid[i][j] == 'W') continue;
        		s[i][j].up = (i == 0 ? 0 : s[i-1][j].up) + (grid[i][j] == 'E' ? 1 : 0);
        		s[i][j].left = (j == 0 ? 0 : s[i][j-1].left) + (grid[i][j] == 'E' ? 1 : 0);
        	}
        }
        int max = 0;
        for (int i = m-1; i >= 0; i--) {
        	for (int j = n-1; j >= 0; j--) {
        		if (grid[i][j] == 'W') continue;
                s[i][j].down = (i == m-1 ? 0 : s[i+1][j].down) + (grid[i][j] == 'E' ? 1 : 0);
        		s[i][j].right = (j == n-1 ? 0 : s[i][j+1].right) + (grid[i][j] == 'E' ? 1 : 0);	
        		if (grid[i][j] == '0') {
        			max = Math.max(max, s[i][j].sum());
        		}	
        	}
        }
        return max;
    }
}