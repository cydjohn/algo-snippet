public class Solution {
	List<List<Integer>> res = new ArrayList();
	List<Integer> list = new ArrayList();
    public List<List<Integer>> getFactors(int n) {
        if (n < 2) return res;
        backtrack(n, 2);
        return res;
    }
    private void backtrack(int n, int cur) {
    	if (n == 1) {
            if (list.size() > 1) res.add(new ArrayList<Integer>(list));
    		return;
    	}
    	for (int i = cur; i <= n; i++) {
    		if (n % i != 0) continue;
    		list.add(i);
    		backtrack(n/i, i);
    		list.remove(list.size() - 1);
    	}
    }
}