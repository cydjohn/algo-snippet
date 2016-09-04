public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> a = new ArrayList();
        a.add(1);
        int[] b = new int[primes.length];
        int res = 1;
        while (n > 1) {//1 has beed added into the list, so only need to get n-1
        	res = Integer.MAX_VALUE;
        	for (int i = 0; i < primes.length; i++) {
        		res = Math.min(res, primes[i]*a.get(b[i]));
        	}
        	a.add(res);
        	n--;
        	for (int i = 0; i < primes.length; i++) {
        		if (res == a.get(b[i])*primes[i]) b[i]++;
        	}
        }
        return res;
    }
}