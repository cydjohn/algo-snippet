//The Sieve of Eratosthenes uses an extra O(n) memory and its runtime complexity is O(n log log n). 
public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        //Yes, the terminating loop condition can be p < √n, as all non-primes ≥ √n must have already been marked off. ［3，4］［6，2］
        for (int i = 2; i * i < n; i++) {
        	if (!isPrime[i]) continue;
            //j starts from i*i, because i*(0 ~ i-1)已经被mark了，例如5*2已经在2的那一轮mark过了
        	for (int j = i * i; j < n; j += i) {
        		isPrime[j] = false;
        	}
        }
        int cnt = 0;
        for (int i = 2; i < n; i++) {
        	if (isPrime[i]) cnt++;
        }
        return cnt;
    }
}