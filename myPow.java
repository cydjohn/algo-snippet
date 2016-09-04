/* 类似BS：
The basic idea is to decompose the exponent into powers of 2, so that you can keep dividing the problem in half. For example, lets say
N = 9 = 2^3 + 2^0 = 1001 in binary. Then:
x^9 = x^(2^3) * x^(2^0)

We can see that every time we encounter a 1 in the binary representation of N, we need to multiply the answer with x^(2^i) where i is the ith bit of the exponent. Thus, we can keep a running total of repeatedly squaring x - (x, x^2, x^4, x^8, etc) and multiply it by the answer when we see a 1.

To handle the case where N=INTEGER_MIN we use a long (64-bit) variable.
since you're dividing N by 2 every iteration that's why it is O(Log N). However, since N is a fixed number of bits (32) you could view it as O(1) where the maximum number iterations is 32. */
public class Solution {
    public double myPow(double x, int n) {
        long m = Math.abs((long)n); //handling overflow when n = - 2147483648 (MAX_VALUE = 2147483647)
        double ans = 1;
        while (m > 0) {
        	if ((m&1) == 1) ans *= x;
        	m >>= 1;
        	x *= x;
        }
        return (n < 0 ? 1/ans : ans);
    }
}

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) return (1/x)*myPow(x, n+1); //handling overflow
        if (n < 0) {
        	n = -n;
        	x = 1/x;
        }
        if (n % 2 == 0) return myPow(x*x, n/2);
        else return x * myPow(x*x, n/2);
    }
}