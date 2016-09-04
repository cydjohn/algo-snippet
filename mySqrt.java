//BS
/*1) for perfect square, such as 4, the process is intuitive;
2) for non-perfect square, such as 8, the output should the floor int of 2sqrt(2) --> 2.
so the invariants of BS should be 
l <= target;
r > target;
return l;*/
public class Solution {
    public int mySqrt(int x) {
    	if (x == 0) return 0;
        int l = 1, r = x;
        while (r - l > 1) {
        	int m = l + ( r -l)/2;
        	if (m <= x/m) l = m; //invariant: l <= target;
        	else r = m;
        }
        return l;
    }
}

//https://discuss.leetcode.com/topic/24532/3-4-short-lines-integer-newton-every-language
public class Solution {
    public int mySqrt(int x) {
        long r = x;
        while (r*r > x) {
        	r = (r + x/r) / 2;
        }
        return (int)r;
    }
}

