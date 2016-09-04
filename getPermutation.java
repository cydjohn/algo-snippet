//math
public class Solution {
    public String getPermutation(int n, int k) {
    	// initialize all numbers
    	List<Integer> list = new ArrayList();
    	for (int i = 1; i <= n; i++) list.add(i);
    	// change k to be index
    	k--;
        int mod = 1;
        for (int i = 1; i <= n; i++) mod = mod * i;
        String res = "";
        // find sequence
        for (int i = 0; i < n; i++) {
        	mod /= (n-i);
        	// find the right number(curIndex) of
        	int cur = k/mod;
        	// update k
        	k %= mod;
        	// get number according to curIndex
        	res += list.get(cur);
        	// remove from list
        	list.remove(cur);
        }
        return res.toString();
    }
}

//backtrack TLE
public class Solution {
	char[] a;
	boolean[] vis;
	int cnt = 0;
    public String getPermutation(int n, int k) {
        a = new char[n];
        vis = new boolean[n+1];
        return backtrack(0, n, k);
    }
    private String backtrack(int cur, int n, int k) {
    	if (cur == n) {
    		cnt++;
    		if (cnt == k) return String.valueOf(a);
    		else return null;
    	}
    	for (int i = 1; i <= n; i++) {
    		if (!vis[i]) {
    			a[cur] = (char)(i+'0');
    			vis[i] = true;
    			String str = backtrack(cur+1, n, k);
    			if (str != null) return str;
    			else vis[i] = false;
    		}
    	}
    	return null;
    }
}

