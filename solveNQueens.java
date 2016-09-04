public class Solution {
	List<List<String>> res = new ArrayList();
	int[] col;
    public List<List<String>> solveNQueens(int n) {
        col = new int[n];
        search(0, n);
        return res;
    }
    private void search(int cur, int n) {
    	if (cur == n) {
    		List<String> solution = new ArrayList();
    		char[] line = new char[n];
    		for (int key : col) {
    			for (int j = 0; j < n; j++) {
    				if (j == key) line[j] = 'Q';
    				else line[j] = '.';
    			}
    			System.out.println(line[0]);
    			solution.add(String.valueOf(line));
    		} 
    		res.add(solution);
    	}
    	else {
    		for (int i = 0; i < n; i++) {
    			boolean ok = true;
    			col[cur] = i;
    			for (int k = 0; k < cur; k++) {
    				if (col[cur] == col[k] || col[cur]-cur == col[k]-k || col[cur]+cur == col[k]+k) {
    					ok = false;
    					break;
    				}
    			}
    			if (ok) search(cur+1, n);
    		}
    	}
    }
}