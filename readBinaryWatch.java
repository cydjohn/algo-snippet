public class Solution {
	int[] time = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
	List<String> res = new ArrayList();
	int hour = 0, second = 0;
	boolean[] vis = new boolean[10];
    public List<String> readBinaryWatch(int num) {
        backtrak(num, 0);
        return res;
    }
    private void backtrak(int num, int cur) {
    	if (num == 0 && hour < 12 && second < 60) {
    		res.add(Integer.toString(hour)+":"+(second > 9 ? "" : "0")+Integer.toString(second));
    		return;
    	}
    	for (int i = cur; i < 10; i++) {
    		if (vis[i]) continue;
    		vis[i] = true;
    		if (i < 4) hour += time[i];
    		else second += time[i];
    		backtrak(num - 1, i + 1);
    		if (i < 4) hour -= time[i];
    		else second -= time[i];
    		vis[i] = false;
    	}
    }
}