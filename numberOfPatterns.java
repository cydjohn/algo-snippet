public class Solution {
	boolean[] vis;
	int[][] mid;
    public int numberOfPatterns(int m, int n) {
        mid = new int[10][10];
        vis = new boolean[10];
        mid[1][3] = mid[3][1] = 2;
        mid[4][6] = mid[6][4] = 5;
        mid[7][9] = mid[9][7] = 8;
        mid[1][7] = mid[7][1] = 4;
        mid[2][8] = mid[8][2] = 5;
        mid[3][9] = mid[9][3] = 6;
	    mid[1][9] = mid[9][1] = mid[3][7] = mid[7][3] = 5;
	    int cnt = 0;
	    cnt += dfs(1, 1, 0, m, n) * 4;
	    cnt += dfs(2, 1, 0, m, n) * 4;
	    cnt += dfs(5, 1, 0, m, n);
	    return cnt;
    }
    private int dfs(int num, int len, int cnt, int m, int n) {
    	if (len >= m) cnt++;
    	if (len + 1 > n) return cnt;
    	vis[num] = true;
    	for (int i = 1; i <= 9; i++) {
    		int jump = mid[num][i];
    		if (!vis[i] && (jump == 0 || vis[jump])) {
    			cnt = dfs(i, len+1, cnt, m, n);
    		}
    	}
    	vis[num] = false;
    	return cnt;
    }
}