//https://discuss.leetcode.com/topic/27565/java-python-one-pass-solution-easy-to-understand
//逐次考虑每一位可能带来的1的总数
public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int q = n, x = 1;
        int ans = 0;
        while (q != 0) {
        	int digit = q % 10;
        	q /= 10;
        	ans += q * x;
        	if (digit == 1) ans += n % x + 1;
        	else if (digit > 1) ans += x; 
        	x *= 10;
        }
        return ans;
    }
}