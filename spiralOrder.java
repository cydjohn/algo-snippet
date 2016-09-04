public class Solution {
	int x = 0, y = 0, state = 0;
	boolean[][] vis;
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> res = new ArrayList();
    	if (matrix.length == 0 || matrix[0].length == 0) return res;
    	int m = matrix.length;
    	int n = matrix[0].length;
        vis = new boolean[m][n];
        for (int i = 0; i < m*n; i++) {
        	res.add(matrix[x][y]);
        	vis[x][y] = true;
        	changeXY(m, n);
        }
        return res;
    }
    private void changeXY(int m, int n) {
    	if (state == 0) {
    		if (y == n-1 || vis[x][y+1]) {
    			state = 1; 
    			x++;
    		}
    		else y++;
    	}
    	else if (state == 1) {
    		if (x == m-1 || vis[x+1][y]) {
    			state = 2;
    			y--;
    		}
    		else x++;
    	}
    	else if (state == 2) {
    		if (y == 0 || vis[x][y-1]) {
    			state = 3;
    			x--;
    		}
    		else y--;
    	}
    	else {
    		if (x == 0 || vis[x-1][y]) {
    			state = 0;
    			y++;
    		}
    		else x--;
    	}
    }
}