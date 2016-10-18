//pitfall: 加法乘法等都可能带来overflow，尤其在math类的题目integer overflow是一个常见的corner cases
public class Solution {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
        	res = res * 10 + x % 10;
        	x /= 10;
        	if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        return (int)res;
    }
}