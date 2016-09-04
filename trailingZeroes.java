//Because all trailing 0 is from factors 5 * 2.
//But sometimes one number may have several 5 factors, for example, 25 have two 5 factors, 125 have three 5 factors. In the n! operation, factors 2 is always ample. So we just count how many 5 factors in all number from 1 to n.
//n!后缀0的个数 = n!质因子中5的个数 = floor(n/5)+floor(n/25)+floor(n/125)+....因为逢25的数需要增加1个5因子。
public class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }
}

public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
        	n /= 5;
        	res += n;
        }
        return res;
    }
}