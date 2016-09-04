//https://discuss.leetcode.com/topic/50458/1-liners-other-with-explanations/2
public class Solution {
    public int superPow(int a, int[] b) {
        int res = 1; int p = a;
        for (int i = b.length-1; i >= 0; i--) {
        	res = res * pow(p, b[i], 1337) % 1337;
        	p = pow(p, 10, 1337);
        }
        return res;
    }
    private int pow(int a, int b, int c) {//a^b might be overfow when a is too big, so we need to mod c here
    	long res = 1;
    	long p = a;
    	while (b > 0) {
    		if ((b & 1) == 1) res = (res*p) % c;
    		p = (p*p) % c; //p might overflow
    	    b >>= 1;
    	}
    	return (int)res;
    }
}

//point: deal with possible overflow problem by mod c in every step. implement pow()