//The Sieve of Eratosthenes uses an extra O(n) memory and its runtime complexity is O(n log log n). 
public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
        	if (!isPrime[i]) continue;
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