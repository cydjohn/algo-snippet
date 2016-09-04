//interative
public class Solution {
    List<List<Integer>> res = new ArrayList();
    Integer[] a;
    public List<List<Integer>> combine(int n, int k) {
        a = new Integer[k];
        backtrack(0, 1, k, n);
        return res;
    }
    private void backtrack(int cur, int st, int k, int n) {
        if (cur == k) {
            /*arrays.aslist() needs to use Integer instead of int, and a is pointer, if you don't make a shadow copy of the array, the result will be the last combination of backtrack*/
            res.add(Arrays.asList(a.clone()));
            return;
        } 
        for (int i = st; i <= n; i++) {
            a[cur] = i;
            backtrack(cur+1, i+1, k, n);
        }
    }
}

//recurssive
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return search(n, k, 1, 0);
    }
    private List<List<Integer>> search(int n, int k, int start, int cur) {
    	List<List<Integer>> res = new ArrayList();
    	if (cur == k) {
    		List<Integer> temp = new ArrayList();
    		res.add(temp);
    		return res;
    	}
    	for (int i = start; i <= n; i++) {
    		List<List<Integer>> next = search(n, k, i+1, cur+1);
    		if (next != null) {
    			for (List<Integer> t : next) t.add(0, i);
    			res.addAll(next);
    		}
    	}
    	return res;
    }
}


