//断点DP O(n^3)
public class Solution {
    public int minCut(String s) {
    	int n = s.length();
        int[][] cut = new int[n][n];
        boolean[][] isPalin = new boolean[n][n];
        for (int k = 1; k < n; k++) {
        	for (int l = 0; l < n-k; l++) {
        		int r = l + k;
        		if (s.charAt(l) == s.charAt(r) && (l+1 >= r-1 || isPalin[l+1][r-1])) isPalin[l][r] = true;
        		if (isPalin[l][r]) cut[l][r] = 0;
        		else {
        			cut[l][r] = Integer.MAX_VALUE;
        			for (int i = l; i < r; i++) {
        				cut[l][r] = Math.min(cut[l][r], cut[l][i]+1+cut[i+1][r]);
        			}
        		}
        	}
        }
        return cut[0][n-1];
    }
}

//断点DP O(n^2)
/*In above approach, we can calculating minimum cut while finding all palindromic substring. If we finding all palindromic substring 1st and then we calculate minimum cut, time complexity will reduce to O(n2).*/
public class Solution {
    public int minCut(String s) {
    	int n = s.length();
        int[] cut = new int[n];
        boolean[][] isPalin = new boolean[n][n];
        for (int k = 1; k < n; k++) {
        	for (int l = 0; l < n-k; l++) {
        		int r = l + k;
        		if (s.charAt(l) == s.charAt(r) && (l+1 >= r-1 || isPalin[l+1][r-1])) isPalin[l][r] = true;
        	}
        }
        for (int i = 0; i < n; i++) {
        	if (isPalin[0][i]) cut[i] = 0;
        	else {
        		cut[i] = Integer.MAX_VALUE;
        		for (int j = 0; j < i; j++) {
        			if (isPalin[j+1][i] && 1 + cut[j] < cut[i]) cut[i] = 1 + cut[j];
        		}
        	}
        }
        return cut[n-1];
    }
}








