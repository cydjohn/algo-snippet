public class Solution {
	Integer code[];
	boolean[] vis;
	boolean found = false;
    public List<Integer> grayCode(int n) {
    	int len = (int) Math.pow(2, n);
    	vis = new boolean[len];
    	code = new Integer[len];
    	code[0] = 0;
    	vis[0] = true;
        search(1, len);
        List<Integer> res = Arrays.asList(code);
        return res;
    }
    private void search(int cur, int n) {
    	if (cur == n) {
    		found = true;
    		return;
    	}
    	for (int i = 1; i < n; i++) {
    		if (found) return;
    		if (!vis[i] && isGrayCode(i, code[cur-1])) {
    			code[cur] = i;
    			vis[i] = true;
    			search(cur+1, n);
    			vis[i] = false;
    		}
    	}
    }
    private boolean isGrayCode(int num1, int num2) {
    	int diff = 0;
    	while (num1 > 0 || num2 > 0) {
    		if ((num1 & 1) != (num2 & 1)) diff++;
    		num1 >>= 1;
    		num2 >>= 1;
    	}
    	return (diff == 1);
    }
}