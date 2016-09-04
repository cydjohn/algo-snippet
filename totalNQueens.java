public class Solution {
	int[] col;
	int tot = 0;
    public int totalNQueens(int n) {
        col = new int[n];
        search(0, n);
        return tot;
    }
    private void search(int cur, int n) {
    	if (cur == n) tot++;
    	else {
    		for (int i = 0; i < n; i++) {
    			boolean ok = true;
    			col[cur] = i; //put a quen at the cur row and the ith column
    			for (int j = 0; j < cur; j++) {
    				if (col[cur] == col[j] || col[cur]-cur == col[j]-j || col[cur]+cur == col[j]+j) {
    					ok = false;
    					break;
    				}
    			}
    			if (ok) search(cur+1);
    		}
    	}
    }
}