public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> a = new ArrayList();
        a.add(1);
        int[] b = new int[3];
        int[] c = {2,3,5};
        int res = 1;
        while (n > 1) {
        	res = Math.min(Math.min(a.get(b[0])*2, a.get(b[1])*3), a.get(b[2])*5);
        	a.add(res);
            n--;
        	for (int i = 0; i < 3; i++) {
        		if (res == a.get(b[i])*c[i]) b[i]++;
        	}
        }
        return res;
    }
}