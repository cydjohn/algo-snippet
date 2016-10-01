public class Solution {
	List<String> res = new ArrayList();
	int[] num = new int[]{0, 1, 6, 8, 9};
	List<Integer> list = new ArrayList();
    public List<String> findStrobogrammatic(int n) {
        if (n < 1) return res;
        backtrack(0, n);
        return res;
    }
    private void backtrack(int cur, int n) {
    	if (cur == (n+1)/2) {
    		print(list, n);
    		return;
    	}
    	for (int i = 0; i < num.length; i++) {
    		if (n != 1 && cur == 0 && i == 0) continue;//两位数以上第一位不能为0
    		if ((n % 2 != 0 && cur == n/2) && (i == 2 || i == 4)) continue;//位数为奇数的中间的哪一位不能为6或者9
    		list.add(num[i]);
    		backtrack(cur+1, n);
    		list.remove(list.size()-1);
    	}
    }
    private void print(List<Integer> list, int n) {
    	StringBuilder sb = new StringBuilder();
    	for (int i : list) {
    		sb.append(i);
    	}
    	int i = list.size() - 1;
    	if (n % 2 != 0) i--;
    	for (; i >= 0; i--) {
    		int cur = list.get(i);
    		if (cur == 6) cur = 9;
    		else if (cur == 9) cur = 6;
    		sb.append(cur);
    	}
    	res.add(sb.toString());
    }
}