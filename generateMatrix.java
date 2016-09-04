//2-d traversal
public class Solution {
	int x = 0, y = 0, state = 0;
	boolean[][] vis;
    public int[][] generateMatrix(int n) {
    	int[][] a = new int[n][n];
    	vis = new boolean[n][n];
        for (int i = 1; i <= n*n; i++) {
        	a[x][y] = i;
        	vis[x][y] = true;
        	changeXY(n);
        }
        return a;
    }
    private void changeXY(int n) {
    	if (state == 0) {
    		if (y == n-1 || vis[x][y+1]) {
    			state = 1; 
    			x++;
    		}
    		else y++;
    	}
    	else if (state == 1) {
    		if (x == n-1 || vis[x+1][y]) {
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