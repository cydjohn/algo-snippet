//interative
public class Solution {
    List<List<Integer>> res = new ArrayList();
    List<Integer> list = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, 0, target, candidates);
        return res;
    }
    private void backtrack(int cur, int st, int n, int[] a) {
        if (cur >= n) {
            /*list could not be passed as result directly, since list is only a pointer, when we finish the backtrack, it will point to a empty list space, which is not we want. so make a shadow copy of list by creating a space to store list's values, don't use clont().*/
            if (cur == n) res.add(new ArrayList(list));
            return;
        }
        /*start building the list from st, previous selected num, to avoid duplicate combinations*/
        for (int i = st; i < a.length; i++) {
            list.add(a[i]);
            cur += a[i];
            backtrack(cur, i+1, n, a);
            cur -= a[i];
            list.remove(list.size()-1);
            /*skip successive duplicate elements to avoid duplicate combinations in the same step*/
            while (i < a.length-1 && a[i] == a[i+1]) i++; 
        }
    }
}

//recurssive
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return search(candidates, target, 0);
    }
    private List<List<Integer>> search(int[] c, int n, int st) {
        List<List<Integer>> res = new ArrayList();
    	if (n < 0) return null;
    	if (n == 0) {
    		List<Integer> temp = new ArrayList();
    		res.add(temp);
    		return res;
    	}
    	for (int i = st; i < c.length; i++) {
    		List<List<Integer>> next = search(c, n-c[i], i+1);
            if (next != null) {
                for (List<Integer> t : next) t.add(0, c[i]);
                res.addAll(next);
            }
            while (i < c.length-1 && c[i] == c[i+1]) i++;
    	}
        return res;
    }
}


