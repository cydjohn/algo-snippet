//dp O(n^2)
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
    	int n = envelopes.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        /*ensure the smaller (i, j) get dp result before bigger pairs in dp loop*/
        Arrays.sort(envelopes, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a, int[] b) {
        		return a[0] - b[0];
        	}
        });
        int max = 1;
        for (int i = 0; i < n; i++) {
        	for (int j = i - 1; j >= 0; j--) {
        		if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        			if (max < dp[i]) max = dp[i];
        		}
        	}
        }
        return max;
    }
}

//BS O(nlogn)
/*
1. Sort the array. Ascend on width and descend on height if width are same. 
2. Find the longest increasing subsequence based on height.Since the width is increasing, we only need to consider height.
*/
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                /*[3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4].*/
                if (a[0] == b[0]) return b[1] - a[1];
                else return a[0] - b[0];
            }
        });
        int len = 0;
        int[] sub = new int[n];
        for (int[] e : envelopes) {
            int idx = Arrays.binarySearch(sub, 0, len, e[1]); //toIndex - the index of the last element (exclusive) to be searched
            if (idx < 0) idx = -(idx + 1);
            sub[idx] = e[1];
            if (idx == len) len++;
        }
        return len;
    }
}