//interative
public class Solution {
	List<List<Integer>> res = new ArrayList();
	List<Integer> list = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
    		backtrack(cur, i, n, a);
    		cur -= a[i];
    		list.remove(list.size()-1);
    	}
    }
}

//interation with DP
public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new LinkedList<List<Integer>>();
        //Arrays.sort(nums);
        HashMap<Integer, List<List<Integer>>> dp = new HashMap<Integer, List<List<Integer>>>();
        dp.put(0, new LinkedList<List<Integer>>());
        dp.get(0).add(new LinkedList<Integer>());
        
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            for(int j = cur; j <= target; j++){
                if(dp.containsKey(j - cur)){
                    for(List<Integer> sol : dp.get(j - cur)){
                        List<Integer> curSol = new LinkedList<Integer>(sol);
                        curSol.add(cur);
                        if(!dp.containsKey(j)){
                            dp.put(j, new LinkedList<List<Integer>>());
                        }
                        dp.get(j).add(curSol);
                    }
                }
            }
        }
        if(dp.get(target) == null)  
            return new LinkedList<List<Integer>>();
        return dp.get(target);
    }
}


//recurssive
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
    	for (int i = st; i < cn.length; i++) {
    		List<List<Integer>> next = search(c, n-c[i], i);
            if (next != null) {
                for (List<Integer> t : next) t.add(0, c[i]);
                res.addAll(next);
            }
    	}
        return res;
    }
}

