public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {//deal with overflow
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        boolean isNegative = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0));
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;//when dividend = -2147483648, the res = 2147483648, but the Integer.MAX_VALUE = 2147483647，so res will got out of upper bound of int, and become -2147483648
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int res = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= (b << (shift + 1))) {
                shift++;
            }
            a -= b << shift;
            res += 1 << shift;//calculate the num of shift
        }
        return isNegative ? -res : res;
    }
}