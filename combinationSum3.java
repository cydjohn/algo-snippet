public class Solution {
	List<List<Integer>> res = new ArrayList();
	Integer[] a;
    public List<List<Integer>> combinationSum3(int k, int n) {
        a = new Integer[k];
        backtrack(0, 1, k, n);
        return res;
    }
    private void backtrack(int cur, int st, int k, int n) {
    	if (cur == k) {
    		if (n == 0) res.add(Arrays.asList(a.clone()));
    		return;
    	}
    	for (int i = st; i <= 9; i++) {
    		a[cur] = i;
    		backtrack(cur+1, i+1, k, n-i);
    	}
    }
}

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return search(k, n, 1);
    }
    private List<List<Integer>> search(int k, int target, int start) {
        List<List<Integer>> res = new ArrayList();
        if (k == 0) {
        	if (target == 0) {
    		    List<Integer> temp = new ArrayList();
    		    res.add(temp);
    		    return res;
    	    }
    	    else return null;
        }
    	for (int i = start; i < 10; i++) {
    		List<List<Integer>> next = search(k-1, target-i, i+1);
            if (next != null) {
                for (List<Integer> t : next) t.add(0, i);
                res.addAll(next);
            }
    	}
        return res;
    }
}

